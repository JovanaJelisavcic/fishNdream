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
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.intercations.SubscriptionBoat;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/boat")
public class BoatController {
	
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/subscribe/{boatId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> subscribe(@RequestHeader("Authorization") String token, @PathVariable int boatId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Boat> boat =  boatRepo.findById(boatId);
		if(boat.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Boat not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(fisherman.get().alreadySubscribedBoat(boat.get().getBoatId())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman already subscribed to this boat");
		SubscriptionBoat newOne = new SubscriptionBoat(fisherman.get(),boat.get());
	
		fisherman.get().addSubscriptionBoat(newOne);
		boat.get().addNewSubscription(newOne);
		
		fishermanRepo.save(fisherman.get());
		boatRepo.save(boat.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/unsubscribe/{boatId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> unsubscribe(@RequestHeader("Authorization") String token, @PathVariable int boatId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Boat> boat =  boatRepo.findById(boatId);
		if(boat.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Boat not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(!fisherman.get().alreadySubscribedBoat(boat.get().getBoatId())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman wasn't subscribed to this boat");
		fisherman.get().removeSubscriptionBoat(boat.get().getBoatId());
		boat.get().removeSubscription(fisherman.get().getEmail());
		
		fishermanRepo.save(fisherman.get());
		boatRepo.save(boat.get());
		return ResponseEntity.ok().build();
	}
	
	@JsonView(Views.BoatProfile.class)
	@GetMapping("/{boatId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeBoats( @PathVariable int boatId )  {	
		Optional<Boat> boat =  boatRepo.findById(boatId);
		if(boat.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(boat, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@GetMapping("/")
	public ResponseEntity<?> allBoats( )  {	
		List<Boat> boats =  boatRepo.findAll();
		if(boats.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(boats, HttpStatus.OK);
	}
	
	@JsonView(Views.BoatProfile.class)
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> allBoatsFisher( )  {	
		List<Boat> boats =  boatRepo.findAll();
		if(boats.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(boats, HttpStatus.OK);
	}
	
	
}
