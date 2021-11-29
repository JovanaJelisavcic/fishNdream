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
import com.fishNdream.backend.entity.users.Admin;
import com.fishNdream.backend.repository.AdminRepository;
import com.fishNdream.backend.security.JwtUtils;

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

}
