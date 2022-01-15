package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.intercations.SubscriptionInstructor;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.AdventureRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.repository.InstructorRepository;
import com.fishNdream.backend.security.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	InstructorRepository instructorRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	AdventureRepository adventureRepo;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/subscribe/{email}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> subscribe(@RequestHeader("Authorization") String token, @PathVariable String email) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Instructor> instructor =  instructorRepo.findById(email);
		if(instructor.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Instructor not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(fisherman.get().alreadySubscribedInstructor(instructor.get().getEmail())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman already subscribed to this instructor");
		SubscriptionInstructor newOne = new SubscriptionInstructor(fisherman.get(),instructor.get());
	
		fisherman.get().addSubscriptionInstructor(newOne);
		instructor.get().addNewSubscription(newOne);
		System.out.println("subsribing to "+ instructor.get());
		fishermanRepo.save(fisherman.get());
		instructorRepo.save(instructor.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/unsubscribe/{email}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> unsubscribe(@RequestHeader("Authorization") String token, @PathVariable String email) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Instructor> instructor =  instructorRepo.findById(email);
		if(instructor.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Instructor not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(!fisherman.get().alreadySubscribedInstructor(instructor.get().getEmail())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman wasn't subscribed to this instructor");
		fisherman.get().removeSubscriptionInstructor(instructor.get().getEmail());
		instructor.get().removeSubscription(fisherman.get().getEmail());
		
		fishermanRepo.save(fisherman.get());
		instructorRepo.save(instructor.get());
		return ResponseEntity.ok().build();
	}
	
	@JsonView(Views.InstructorProfile.class)
	@GetMapping("/{email}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeBoats( @PathVariable String email )  {	
		Optional<Instructor> instructor =  instructorRepo.findById(email);
		if(instructor.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@GetMapping("/")
	public ResponseEntity<?> allBoats( )  {	
		List<Adventure> instructor =  adventureRepo.findAll();
		if(instructor.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	
	@JsonView(Views.InstructorProfile.class)
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('FISHERMAN') or hasAuthority('SYS_ADMIN') ")
	public ResponseEntity<?> allBoatsFisher( )  {	
		List<Adventure> instructor =  adventureRepo.findAll();
		if(instructor.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(instructor, HttpStatus.OK);
	}
	
}

