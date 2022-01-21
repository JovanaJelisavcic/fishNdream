package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.ActionType;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.helper.CanceledAction;
import com.fishNdream.backend.entity.helper.ReservationDTO;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.CanceledActionRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.repository.ReservationBoatRepository;
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
	ReservationBoatRepository reservBoatRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	CanceledActionRepository canceledRepo;
	
	@Autowired
	MailUtil mailUtil;
	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/price/{id}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> searchServicess(@RequestParam("begin") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime begin,@RequestParam("end") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime end, @PathVariable int id)  {	
		Optional<Boat> boat =  boatRepo.findById(id);
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		long duration = ChronoUnit.MINUTES.between(begin, end);
		int addition = (duration%60==0)?0:1;
		float original=boat.get().getPrice()*(Math.round(duration/60)+ addition);
		 return new ResponseEntity<>(original, HttpStatus.OK);
	}

	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services/{id}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> servicesBoat(@PathVariable int id, @RequestParam("begin") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime begin,@RequestParam("end") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime end )  {
		Optional<Boat> boat =  boatRepo.findById(id);
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesBoat> services = boat.get().getAdditionalServicesForTime(begin,end);		
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@JsonView(Views.AdditionalServices.class)
	@GetMapping("/services/{id}/{criteria}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> searchServices(@RequestParam("begin") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime begin,@RequestParam("end") 
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime end, @PathVariable String criteria, @PathVariable int id)  {	
		Optional<Boat> boat =  boatRepo.findById(id);
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		List<AdditionalServicesBoat> services = boat.get().getAdditionalServicesForTime(begin,end);
		services.removeIf(p -> !p.getName().toUpperCase().contains(criteria.toUpperCase()));
		if(services.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	@GetMapping("/actions/{boatId}")
	@JsonView(Views.ActionInfo.class)
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> actionsBoat(@PathVariable int boatId )  {
		Optional<Boat> boat =  boatRepo.findById(boatId);
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		List<ReservationBoat> actions = boat.get().getActiveActions();		
		if(actions.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(actions, HttpStatus.OK);
	}
	
	@PostMapping("/actions/reserve/{actionId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> confirmAction(@RequestHeader("Authorization") String token, @PathVariable int actionId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ReservationBoat> action =  reservBoatRepo.findByReservationIdAndActionRes(actionId, true);
		if(action.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Action not found");	
		if(LocalDateTime.now().isAfter(action.get().getActionEndTime()) || LocalDateTime.now().isBefore(action.get().getActionStartTime())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Action is not active");
		
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(fisherman.get().alreadyReservedActionBoat(action.get().getReservationId())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Entity already had been reserved by this user for this period");
		
	
		fisherman.get().addReservationBoat(action.get());
		action.get().getBoat().changeActionRes(action.get().getReservationId(), fisherman.get());
		
		boolean containsCapetain =action.get().getAdditionalServices().stream().anyMatch(a
                -> (a.getName().equals("Capetain")));
		
		
		
		Boat toSaveBoatAction = action.get().getBoat().removeAction(action.get().getBeginning(),action.get().getEnding(), containsCapetain );
		if(toSaveBoatAction!=null && toSaveBoatAction.getBoatId()!=action.get().getBoat().getBoatId())  boatRepo.save(toSaveBoatAction);
		
		fishermanRepo.save(fisherman.get());
		boatRepo.save(action.get().getBoat());

		mailUtil.sendReservationBoatConfirmation(fisherman.get().getEmail(), action.get());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/confirm")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> confirmBoat(@RequestHeader("Authorization") String token,@Valid @RequestBody ReservationDTO reservation) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
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
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(fisherman.get().alreadyReservedBoat(reservation.getEntityId(), reservation.getBeginning(),reservation.getEnding())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("Entity already had been reserved by this user for this period");
		
		long duration= ChronoUnit.MINUTES.between(reservation.getBeginning(), reservation.getEnding());
		int addition = (duration%60==0)?0:1;
		float price=boat.get().getPrice()*(Math.round(duration/60)+ addition);
		
		ReservationBoat newReservation = new ReservationBoat();
		List<AdditionalServicesBoat> services = new ArrayList<>();
		boolean containsCaptain=false;
		for(int serviceId : reservation.getServicesIds()) {
			boolean found = false;
			for(AdditionalServicesBoat service : boat.get().getAdditionalServicesForTime(reservation.getBeginning(),reservation.getEnding())) {
				if(service.getServiceId()==serviceId) {
					if(service.getName().toUpperCase().contains("Capetain".toUpperCase())) containsCaptain=true;
					services.add(service);
					price+=service.getPrice();
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
		newReservation.setPrice(price);
		newReservation.setPercentageRevenue(Float.parseFloat(System.getProperty("app.percentage")));
		fisherman.get().addReservationBoat(newReservation);
		boat.get().addReservation(newReservation);
		Boat toSaveBoatAction = boat.get().removeAction(newReservation.getBeginning(),newReservation.getEnding(), containsCaptain );
		if(toSaveBoatAction!=null && toSaveBoatAction.getBoatId()!=boat.get().getBoatId())  boatRepo.save(toSaveBoatAction);
		
		//fishermanRepo.save(fisherman.get());
		reservBoatRepo.save(newReservation);
		boatRepo.save(boat.get());

		mailUtil.sendReservationBoatConfirmation(fisherman.get().getEmail(), newReservation);
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/cancel/{reservationId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> cancelRes(@RequestHeader("Authorization") String token, @PathVariable int reservationId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ReservationBoat> reservation =  reservBoatRepo.findByReservationIdAndActionRes(reservationId, false);
		if(reservation.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Reservations not found");		
		if(LocalDateTime.now().isAfter(reservation.get().getBeginning().minusHours(72))) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("You can't cancel less than 3 days before beginning");
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(!username.equals(reservation.get().getFisherman().getEmail())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("This reservation isn't yours");
		fisherman.get().cancelReservationBoat(reservation.get().getReservationId());
		reservation.get().getBoat().cancelReservation(reservation.get().getReservationId());
		
		fishermanRepo.save(fisherman.get());
		boatRepo.save(reservation.get().getBoat());

		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/actions/cancel/{actionId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> cancelAction(@RequestHeader("Authorization") String token, @PathVariable int actionId) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ReservationBoat> action =  reservBoatRepo.findByReservationIdAndActionRes(actionId, true);
		if(action.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Action not found");		
		if(LocalDateTime.now().isAfter(action.get().getBeginning().minusHours(72))) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("You can't cancel less than 3 days before beginning");
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(!username.equals(action.get().getFisherman().getEmail())) return ResponseEntity
	            .status(HttpStatus.FORBIDDEN)
	            .body("This isn't your reservation");
		CanceledAction actionCan = new CanceledAction();
		actionCan.setActionId(actionId);
		actionCan.setActionType(ActionType.BOAT);
		actionCan.setFisherman(fisherman.get());
		fisherman.get().addCancelAction(actionCan);
		action.get().getBoat().cancelActionRes(action.get().getReservationId());
		fishermanRepo.save(fisherman.get());
		boatRepo.save(action.get().getBoat());
		canceledRepo.save(actionCan);
		return ResponseEntity.ok().build();
	}
	

}
