package com.fishNdream.backend.controller;


import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.UserInfo;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.security.ERole;
import com.fishNdream.backend.security.JwtResponse;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.security.Role;
import com.fishNdream.backend.security.RoleRepository;
import com.fishNdream.backend.security.User;
import com.fishNdream.backend.security.UserDetailsImpl;
import com.fishNdream.backend.security.UserDetailsServiceImpl;
import com.fishNdream.backend.security.UserRepository;






@RestController
@RequestMapping("/register")
public class RegisterController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	AuthenticationManager authenticationManager;

	 @Autowired
	 private UserDetailsServiceImpl service;
	@Autowired
	FishermanRepository fishermanRepo;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;


	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody User loginRequest) throws UnsupportedEncodingException, URISyntaxException {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		logger.info(loginRequest.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt,
												 loginRequest.getUsername(), roles));
	}
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "signup_form";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('FISHERMAN') or hasAuthority('SYS_ADMIN')")
	public String userAccess() {
		return "any user";
	}

	@GetMapping("/patient")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public String patientAccess() {
		return "fISHERMAN";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('SYS_ADMIN')")
	public String adminAccess() {
		return "Admin";
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserInfo signUpRequest, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
		if (userRepository.existsByUsername(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest().build();
		}
		Fisherman tosave = new Fisherman(signUpRequest);
		Fisherman otherCheck =  fishermanRepo.save(tosave);
		if(otherCheck!=null) {
			logger.info(signUpRequest.getPassword());
			User user = new User(signUpRequest.getEmail(), 
					 signUpRequest.getPassword());
				Set<Role> userRole = new HashSet<>();
					userRole.add(roleRepository.findByName(ERole.FISHERMAN));
					user.setRoles(userRole);
			service.register(user, getSiteURL(request));
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
			
	}
	
	 private String getSiteURL(HttpServletRequest request) {
	        String siteURL = request.getRequestURL().toString();
	        return siteURL.replace(request.getServletPath(), "");
	    }  
	 
	 @GetMapping("/verify")
	 public String verifyUser(@Param("code") String code) {
	     if (service.verify(code)) {
	         return "verify_success";
	     } else {
	         return "verify_fail";
	     }
	 }
	 
}