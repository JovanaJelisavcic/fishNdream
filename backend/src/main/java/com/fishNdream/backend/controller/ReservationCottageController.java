package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesCottage;
import com.fishNdream.backend.entity.helper.ReservationDTO;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.util.MailUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/reservationCottage")
public class ReservationCottageController {

	@Autowired
	CottageRepository cottagesRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	MailUtil mailUtil;

	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services/{cottageId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> servicesCottage(@PathVariable int cottageId)  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesCottage> services = cottage.get().getAdditionalServices();
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services/{cottageId}/{criteria}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeCottages(@PathVariable int cottageId, @PathVariable String criteria )  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesCottage> services = cottage.get().getAdditionalServices();
		services.removeIf(p -> !p.getName().toUpperCase().contains(criteria.toUpperCase()));
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@PostMapping("/confirm")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> confirmCottage(@RequestHeader("Authorization") String token,@RequestBody ReservationDTO reservation) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(reservation.getEntityId());
		if(cottage.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Cottage not found");
		if(reservation.getParticipantsNum()==0) reservation.setParticipantsNum(1);
		if(!cottage.get().isAvailableAndFree(reservation.getBeginning(), reservation.getEnding()) || cottage.get().getGuestsNum()<reservation.getParticipantsNum())
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("Not free at these conditions");
		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(fisherman.get().alreadyReservedCottage(reservation.getEntityId(), reservation.getBeginning(),reservation.getEnding())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Entity already had been reserved by this user for this period");
		
		
		ReservationCottage newReservation = new ReservationCottage();
		List<AdditionalServicesCottage> services = new ArrayList<>();
		for(int serviceId : reservation.getServicesIds()) {
			boolean found = false;
			for(AdditionalServicesCottage service : cottage.get().getAdditionalServices()) {
				if(service.getServiceId()==serviceId) {
					services.add(service);
					found=true;
					break;
				}
			}	
			if(!found) return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body("Service doesn't exist");
		}
		newReservation.setAdditionalServices(services);
		newReservation.setActionEndTime(null);
		newReservation.setActionRes(false);
		newReservation.setActionStartTime(null);
		newReservation.setBeginning(reservation.getBeginning());
		newReservation.setCanceled(false);
		newReservation.setCottage(cottage.get());
		newReservation.setEnding(reservation.getEnding());
		newReservation.setFisherman(fisherman.get());
		newReservation.setParticipantsNum(reservation.getParticipantsNum());
		newReservation.setPrice(0);
		
		fisherman.get().addReservationCottage(newReservation);
		cottage.get().addReservation(newReservation);
		
		fishermanRepo.save(fisherman.get());
		cottagesRepo.save(cottage.get());
		
		mailUtil.sendReservationCottageConfirmation(fisherman.get().getEmail(), newReservation);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
