package com.fishNdream.backend.controller;

import java.io.UnsupportedEncodingException;

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

}
