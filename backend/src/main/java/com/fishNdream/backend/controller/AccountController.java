package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
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
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.DeleteAccountRequest;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.repository.DeleteRequestRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.security.User;
import com.fishNdream.backend.security.UserRepository;
import com.fishNdream.backend.util.MailUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestController
@RequestMapping("/deleteAccount")
public class AccountController {
	
	@Autowired
	FishermanRepository fishermanRepo;

	@Autowired
	DeleteRequestRepository requestRepository;
	
	@Autowired
	UserRepository userRepository;


	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	MailUtil mailUtil;
	
	@PostMapping("/request")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> deleteAccount(@RequestHeader("Authorization") String token, @RequestBody String rqText) throws UnsupportedEncodingException, URISyntaxException {
		String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		Optional<Fisherman> fisherman = fishermanRepo.findById(username);
		DeleteAccountRequest req = new DeleteAccountRequest();
		req.setFisherman(fisherman.get());
		req.setProcessed(false);
		req.setPermited(false);
		req.setRequestText(rqText);
		req.setResponse(null);
		requestRepository.save(req);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@PostMapping("/accept/{requestId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> acceptRq(@PathVariable int requestId,  @RequestBody String resp ) throws UnsupportedEncodingException, MessagingException {
		Optional<DeleteAccountRequest> req = requestRepository.findById(requestId);
		req.get().setPermited(true);
		req.get().setProcessed(true);
		req.get().setResponse(resp);
		requestRepository.save(req.get());
		mailUtil.sendDeletionResponse(req.get());
		Optional<User> user = userRepository.findByUsername(req.get().getFisherman().getEmail());
		userRepository.deleteById(user.get().getId());
		Optional<Fisherman> fisherman = fishermanRepo.findById(req.get().getFisherman().getEmail());
		fisherman.get().removeFK();
		fishermanRepo.deleteById(req.get().getFisherman().getEmail());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@PostMapping("/refuse/{requestId}")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> refuseRq(@PathVariable int requestId,  @RequestBody String resp ) throws UnsupportedEncodingException, MessagingException {
		Optional<DeleteAccountRequest> req = requestRepository.findById(requestId);
		req.get().setProcessed(true);
		req.get().setResponse(resp);
		requestRepository.save(req.get());
		mailUtil.sendDeletionResponse(req.get());
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@JsonView(Views.DeleteRq.class)
	@GetMapping("/requests")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public ResponseEntity<?> myProfile(@RequestHeader("Authorization") String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {	
		 List<DeleteAccountRequest> list =requestRepository.getByProcessed();
		 if(list.isEmpty()) return ResponseEntity.notFound().build();
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
