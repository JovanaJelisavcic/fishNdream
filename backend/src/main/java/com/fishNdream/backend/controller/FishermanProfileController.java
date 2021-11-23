package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.ChangeInfoDTO;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
import com.fishNdream.backend.entity.intercations.SubscriptionBoat;
import com.fishNdream.backend.entity.intercations.SubscriptionCottage;
import com.fishNdream.backend.entity.intercations.SubscriptionInstructor;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/fisherman")
public class FishermanProfileController {
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	FishermanRepository fishermanRepo;
	
	@JsonView(Views.UserInfo.class)
	@GetMapping("/myprofile")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public Fisherman myProfile(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		return  fishermanRepo.findById(username).get();
	}
	
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> updateProfile(@RequestHeader("Authorization") String token,@Valid @RequestBody ChangeInfoDTO user) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Fisherman newOne = fishermanRepo.findById(username).get();
		if(!user.getEmail().equals(username)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		newOne.changeUserInfo(user);
		fishermanRepo.save(newOne);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@JsonView(Views.UnauthoCottages.class)
	@GetMapping("/myCottageSubscriptions")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<SubscriptionCottage>> mysubscriptions(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<SubscriptionCottage> subscrs=fishermanRepo.findById(username).get().getSubscriptionCotagges();
		if(subscrs.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(subscrs, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@GetMapping("/myBoatSubscriptions")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<SubscriptionBoat>> mysubscriptionsBoat(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<SubscriptionBoat> subscrs=fishermanRepo.findById(username).get().getSubsriptionsBoats();
		if(subscrs.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(subscrs, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@GetMapping("/myInstructorSubscriptions")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<SubscriptionInstructor>> mysubscriptionsInstr(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<SubscriptionInstructor> subscrs=fishermanRepo.findById(username).get().getSubscriptionInstructors();
		if(subscrs.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(subscrs, HttpStatus.OK);
	}
	
	@JsonView(Views.ReservationView.class)
	@GetMapping("/reservations/cottage/future")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<ReservationCottage>> cottageFuture(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<ReservationCottage> reservations=fishermanRepo.findById(username).get().getReservationCottages();
		reservations.removeIf(r-> r.isCanceled() || r.getBeginning().toLocalDate().isBefore(LocalDate.now()));
		if(reservations.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(reservations, HttpStatus.OK);
	}
	
	@JsonView(Views.ReservationView.class)
	@GetMapping("/reservations/boat/future")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<ReservationBoat>> boatFuture(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<ReservationBoat> reservations=fishermanRepo.findById(username).get().getReservationBoats();
		reservations.removeIf(r-> r.isCanceled() || r.getBeginning().isBefore(LocalDateTime.now()));
		if(reservations.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(reservations, HttpStatus.OK);
	}

	@JsonView(Views.ReservationView.class)
	@GetMapping("/reservations/adventure/future")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<List<ReservationAdventure>> adventureFuture(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		List<ReservationAdventure> reservations=fishermanRepo.findById(username).get().getReservationAdventures();
		reservations.removeIf(r-> r.isCanceled() || r.getBeginning().isBefore(LocalDateTime.now()));
		if(reservations.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(reservations, HttpStatus.OK);
	}
}
