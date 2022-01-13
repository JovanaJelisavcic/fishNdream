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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.intercations.ComplaintBoat;
import com.fishNdream.backend.entity.intercations.ComplaintCottage;
import com.fishNdream.backend.entity.intercations.ComplaintInstructor;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.ComplaintBRepository;
import com.fishNdream.backend.repository.ComplaintCRepository;
import com.fishNdream.backend.repository.ComplaintIRepository;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.repository.InstructorRepository;
import com.fishNdream.backend.repository.ReservationBoatRepository;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.util.MailUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {
	
	@Autowired
	CottageRepository cottagesRepo;
	@Autowired
	InstructorRepository instructorRepo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	ReservationBoatRepository resBRepo;
	@Autowired
	MailUtil mailUtil;
	@Autowired
	private ComplaintCRepository cottageComplRepo;
	@Autowired
	private ComplaintBRepository boatComplRepo;
	@Autowired
	private ComplaintIRepository instrComplRepo;
	
	@PostMapping("/file/cottage/{cottageId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> fileCottage(@RequestHeader("Authorization") String token,@PathVariable int cottageId,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Cottage> cottage =  cottagesRepo.findById(cottageId);
		if(cottage.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Cottage not found");
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(!cottage.get().atLeastOnceReserved(fisherman.get().getEmail()))
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("Never reserved this cottage at this owner");
		if(cottage.get().alreadyComplained(fisherman.get().getEmail()))
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("You already filed a complaint");
		ComplaintCottage complaint = new ComplaintCottage();
		complaint.setComplaintText(text);
		complaint.setCottage(cottage.get());
		complaint.setFisherman(fisherman.get());
		complaint.setResponse(null);
		cottage.get().addComplaint(complaint);
		cottagesRepo.save(cottage.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/file/boat/{boatId}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> fileBoat(@RequestHeader("Authorization") String token,@PathVariable int boatId,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Boat> boat =  boatRepo.findById(boatId);
		if(boat.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Boat not found");
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		Optional<ReservationBoat> r = resBRepo.findByBoatIdAndEmail(boatId, fisherman.get().getEmail());
		if(r.isEmpty())
			return ResponseEntity
					.status(HttpStatus.FORBIDDEN)
					.body("Never reserved this boat at this owner");
		if(boat.get().alreadyComplained(fisherman.get().getEmail()))
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("You already filed a complaint");
		ComplaintBoat complaint = new ComplaintBoat();
		complaint.setComplaintText(text);
		complaint.setBoat(boat.get());
		complaint.setFisherman(fisherman.get());
		complaint.setResponse(null);
		boat.get().addComplaint(complaint);
		boatRepo.save(boat.get());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/file/instructor/{email}")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> fileInstructor(@RequestHeader("Authorization") String token,@PathVariable String email,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<Instructor> instr =  instructorRepo.findById(email);
		if(instr.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Instructor not found");
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findByEmail(username);
		if(!instr.get().atLeastOnceReserved(fisherman.get().getEmail()))
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("Never reserved adventure with this instructor");
		if(instr.get().alreadyComplained(fisherman.get().getEmail()))
			return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body("You already filed a complaint");
		ComplaintInstructor complaint = new ComplaintInstructor();
		complaint.setComplaintText(text);
		complaint.setInstructor(instr.get());
		complaint.setFisherman(fisherman.get());
		complaint.setResponse(null);
		instr.get().addComplaint(complaint);
		instructorRepo.save(instr.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/respond/cottage/{complaintId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> respondCottage(@RequestHeader("Authorization") String token,@PathVariable int complaintId,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ComplaintCottage> complaint =  cottageComplRepo.findById(complaintId);
		if(complaint.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Complaint not found");
		complaint.get().setResponse(text);
		cottageComplRepo.save(complaint.get());
		mailUtil.sendComplainResponseC(complaint.get());
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/respond/boat/{complaintId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> respondBoat(@RequestHeader("Authorization") String token,@PathVariable int complaintId,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ComplaintBoat> complaint =  boatComplRepo.findById(complaintId);
		if(complaint.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Complaint not found");
		complaint.get().setResponse(text);
		boatComplRepo.save(complaint.get());
		mailUtil.sendComplainResponseB(complaint.get());
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/respond/instructor/{complaintId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> respondAdventure(@RequestHeader("Authorization") String token,@PathVariable int complaintId,@RequestBody String text) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException, MessagingException  {	
		Optional<ComplaintInstructor> complaint =  instrComplRepo.findById(complaintId);
		if(complaint.isEmpty()) return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Complaint not found");
		complaint.get().setResponse(text);
		instrComplRepo.save(complaint.get());
		mailUtil.sendComplainResponseI(complaint.get());
		return ResponseEntity.ok().build();
	}
	
	
	@JsonView(Views.Complaint.class)
	@GetMapping("/cottages")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> freeBoats()  {	
		List<ComplaintCottage> cottage =  cottageComplRepo.findByResponseIsNull();
		if(cottage.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(cottage, HttpStatus.OK);
	}
	
	
	@JsonView(Views.Complaint.class)
	@GetMapping("/boats")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> complBoats()  {	
		List<ComplaintBoat> boat =  boatComplRepo.findByResponseIsNull();
		if(boat.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(boat, HttpStatus.OK);
	}
	
	@JsonView(Views.Complaint.class)
	@GetMapping("/instructors")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> complInstr()  {	
		List<ComplaintInstructor> instr =  instrComplRepo.findByResponseIsNull();
		if(instr.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(instr, HttpStatus.OK);
	}
	
	
}

