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
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.helper.ReservationDTO;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.util.MailUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/reservationBoat")
public class ReservationBoatController {
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ReservationBoatController.class);
	

	@Autowired
	BoatRepository boatRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	MailUtil mailUtil;

	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> servicesBoat(@RequestBody ReservationDTO reservation )  {
		Optional<Boat> boat =  boatRepo.findById(reservation.getEntityId());
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesBoat> services = boat.get().getAdditionalServicesForTime(reservation.getBeginning(),reservation.getEnding());		
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services/{criteria}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> searchServices(@RequestBody ReservationDTO reservation, @PathVariable String criteria )  {	
		Optional<Boat> boat =  boatRepo.findById(reservation.getEntityId());
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesBoat> services = boat.get().getAdditionalServicesForTime(reservation.getBeginning(),reservation.getEnding());
		services.removeIf(p -> !p.getName().toUpperCase().contains(criteria.toUpperCase()));
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@PostMapping("/confirm")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> confirmBoat(@RequestHeader("Authorization") String token,@RequestBody ReservationDTO reservation) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Boat> boat =  boatRepo.findById(reservation.getEntityId());
		if(boat.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Boat not found");
		if(reservation.getParticipantsNum()==0) reservation.setParticipantsNum(1);
		if(!boat.get().isAvailableAndFree(reservation.getBeginning(), reservation.getEnding()) || boat.get().getCapacity()<reservation.getParticipantsNum())
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("Not free at these conditions");
		
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		if(fisherman.get().alreadyReservedBoat(reservation.getEntityId(), reservation.getBeginning(),reservation.getEnding())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Entity already had been reserved by this user for this period");
		
		
		ReservationBoat newReservation = new ReservationBoat();
		List<AdditionalServicesBoat> services = new ArrayList<>();
		for(int serviceId : reservation.getServicesIds()) {
			boolean found = false;
			for(AdditionalServicesBoat service : boat.get().getAdditionalServicesForTime(reservation.getBeginning(),reservation.getEnding())) {
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
		newReservation.setBoat(boat.get());
		newReservation.setEnding(reservation.getEnding());
		newReservation.setFisherman(fisherman.get());
		newReservation.setParticipantsNum(reservation.getParticipantsNum());
		newReservation.setPrice(0);
		fisherman.get().addReservationBoat(newReservation);
		boat.get().addReservation(newReservation);
		
		fishermanRepo.save(fisherman.get());
		boatRepo.save(boat.get());

		mailUtil.sendReservationBoatConfirmation(fisherman.get().getEmail(), newReservation);
		return ResponseEntity.ok().build();
	}
	

}
