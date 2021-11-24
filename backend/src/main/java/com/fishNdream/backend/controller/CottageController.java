package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
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
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.intercations.SubscriptionCottage;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/cottage")
public class CottageController {
	
	@Autowired
	CottageRepository cottagesRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/subscribe/{cottageId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> subscribe(@RequestHeader("Authorization") String token, @PathVariable int cottageId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Cottage not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(fisherman.get().alreadySubscribedCottage(cottage.get().getCottageId())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman already subscribed to this cottage");
		SubscriptionCottage newOne = new SubscriptionCottage(fisherman.get(),cottage.get());
	
		fisherman.get().addSubscriptionCottage(newOne);
		cottage.get().addNewSubscription(newOne);
		
		fishermanRepo.save(fisherman.get());
		cottagesRepo.save(cottage.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/unsubscribe/{cottageId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> unsubscribe(@RequestHeader("Authorization") String token, @PathVariable int cottageId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Cottage not found");		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(!fisherman.get().alreadySubscribedCottage(cottage.get().getCottageId())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Fisherman wasn't subscribed to this cottage");
		fisherman.get().removeSubscriptionCottage(cottage.get().getCottageId());
		cottage.get().removeSubscription(fisherman.get().getEmail());
		
		fishermanRepo.save(fisherman.get());
		cottagesRepo.save(cottage.get());
		return ResponseEntity.ok().build();
	}
	
	@JsonView(Views.CottageProfile.class)
	@GetMapping("/{cottageId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeBoats( @PathVariable int cottageId )  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(cottage, HttpStatus.OK);
	}
	
	
}
