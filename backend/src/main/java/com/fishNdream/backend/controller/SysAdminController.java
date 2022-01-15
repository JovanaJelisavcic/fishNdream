package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.ChangeInfoDTO;
import com.fishNdream.backend.entity.helper.RevenueItem;
import com.fishNdream.backend.entity.users.Admin;
import com.fishNdream.backend.entity.users.BoatOwner;
import com.fishNdream.backend.entity.users.CottageOwner;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.AdminRepository;
import com.fishNdream.backend.repository.AdventureRepository;
import com.fishNdream.backend.repository.BoatOwnerRepository;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.CottageOwnerRepository;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.repository.InstructorRepository;
import com.fishNdream.backend.repository.ReservationBoatRepository;
import com.fishNdream.backend.repository.ReservationCottageRepository;
import com.fishNdream.backend.repository.RevenueRepository;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.util.RevenueUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/admin")
public class SysAdminController {
	
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	CottageOwnerRepository cottageOwnerRepo;
	@Autowired
	BoatOwnerRepository boatOwnerRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	AdventureRepository adventureRepo;
	@Autowired
	ReservationCottageRepository ctgResRepo;
	@Autowired
	ReservationBoatRepository btResRepo;
	@Autowired
	CottageRepository cottagesRepo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	InstructorRepository instructorRepo;
	@Autowired
	RevenueRepository revenueRepo;
	@Autowired
	RevenueUtil revenueUtil;
	
	@JsonView(Views.UserInfo.class)
	@GetMapping("/myprofile")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public Admin myProfile(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		return  adminRepo.findById(username).get();
	}
	
	
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> updateProfile(@RequestHeader("Authorization") String token,@Valid @RequestBody ChangeInfoDTO user) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Admin newOne = adminRepo.findById(username).get();
		if(!user.getEmail().equals(username)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		newOne.changeUserInfo(user);
		adminRepo.save(newOne);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@JsonView(Views.CottageOwner.class)
	@GetMapping("/cottageOwners")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public List<CottageOwner> getCottageOwners() {
		return  cottageOwnerRepo.findAll();
	}
	
	@JsonView(Views.BoatOwner.class)
	@GetMapping("/boatOwners")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public List<BoatOwner> getBoatOwners() {
		return boatOwnerRepo.findAll();
	}
	
	@JsonView(Views.UserInfo.class)
	@GetMapping("/fishermen")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public List<Fisherman> getFisherman() {
		return fishermanRepo.findAll();
	}
	
	
	@PostMapping("/delete/cottageowner/{email}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> acceptRq(@PathVariable String email){
		Optional<CottageOwner> owner = cottageOwnerRepo.findById(email);
		if(owner.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = ctgResRepo.hasOccupiedFuture(owner.get().getCottagesIds());
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete owner who still has reservations");		
		cottageOwnerRepo.deleteById(owner.get().getEmail());
		return new ResponseEntity<>(HttpStatus.OK);		
	}

	
	
	@PostMapping("/delete/boatowner/{email}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> delBO(@PathVariable String email){
		Optional<BoatOwner> owner = boatOwnerRepo.findById(email);
		if(owner.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = btResRepo.hasOccupiedFuture(owner.get().getBoatsIds());
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete owner who still has reservations");		
		boatOwnerRepo.deleteById(owner.get().getEmail());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	@PostMapping("/delete/cottage/{ctgId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> acceptRq(@PathVariable int ctgId){
		Optional<Cottage> ctg = cottagesRepo.findById(ctgId);
		if(ctg.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = ctgResRepo.hasOccupiedFuture(Arrays.asList(ctg.get().getCottageId()));
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete cottage that still has reservations");		
		cottagesRepo.deleteById(ctg.get().getCottageId());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	@PostMapping("/delete/boat/{boatId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> boatDel(@PathVariable int boatId){
		Optional<Boat> boat = boatRepo.findById(boatId);
		if(boat.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = btResRepo.hasOccupiedFuture(Arrays.asList(boat.get().getBoatId()));
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete boat that still has reservations");		
		boatRepo.deleteById(boat.get().getBoatId());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	@PostMapping("/delete/instructor/{email}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> delinst(@PathVariable String email){
		Optional<Instructor> owner = instructorRepo.findById(email);
		if(owner.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = adventureRepo.hasOccupiedFuture(owner.get().getAdventureIds());
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete owner who still has reservations");		
		instructorRepo.deleteById(owner.get().getEmail());
		return new ResponseEntity<>(HttpStatus.OK);		
	}

	@PostMapping("/delete/fisherman/{email}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> delfish(@PathVariable String email){
		Optional<Fisherman> owner = fishermanRepo.findByEmail(email);
		if(owner.isEmpty()) 
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("It doesn't exist");	
		int i = 0;
		i+=adventureRepo.hasPendingReservations(owner.get().getEmail());
		i+=btResRepo.hasPendingReservations(owner.get().getEmail());
		i+=ctgResRepo.hasPendingReservations(owner.get().getEmail());
		if(i!=0) 
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("You can't delete fisherman who still has reservations");		
		fishermanRepo.deleteById(owner.get().getEmail());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@PostMapping("/gain")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> gain(@RequestBody String newPrc){
	
		System.setProperty("app.percentage", String.valueOf(newPrc));
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	
	@GetMapping("/revenue")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public List<RevenueItem> revenue() {
		List<RevenueItem> newrevenues= revenueUtil.getNewReservationsRevenue();
		revenueRepo.saveAll(newrevenues);
		return revenueRepo.findAll();
				
	}


}
