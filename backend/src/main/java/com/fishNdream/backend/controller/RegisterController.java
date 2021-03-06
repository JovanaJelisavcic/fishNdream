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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fishNdream.backend.entity.helper.PasswordChangeRequest;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.users.Admin;
import com.fishNdream.backend.repository.AdminRepository;
import com.fishNdream.backend.repository.SignUpRequestRepository;
import com.fishNdream.backend.security.ERole;
import com.fishNdream.backend.security.JwtResponse;
import com.fishNdream.backend.security.JwtUtils;
import com.fishNdream.backend.security.Role;
import com.fishNdream.backend.security.RoleRepository;
import com.fishNdream.backend.security.User;
import com.fishNdream.backend.security.UserDetailsImpl;
import com.fishNdream.backend.security.UserDetailsServiceImpl;
import com.fishNdream.backend.security.UserRepository;





@Configuration
@ComponentScan(basePackages = { "com.fishNdream.*" })
@PropertySource("classpath:/prop/config.properties")
@RestController
@RequestMapping("/register")
public class RegisterController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	Environment env;

	@Value("${app.superadmin}")
	private String superAdmin;
	 @Autowired
	 private UserDetailsServiceImpl service;


	@Autowired
	RoleRepository roleRepository;
	@Autowired
	SignUpRequestRepository requestRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminRepo;


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
		boolean isFirst = userDetails.isFirst();
		boolean isSuperAdmin = System.getProperty("app.superadmin").toString().equals(loginRequest.getUsername())? true : false;
		return ResponseEntity.ok(new JwtResponse(jwt,
												 loginRequest.getUsername(), roles, isFirst , isSuperAdmin  ));
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

	
	
	@PostMapping("/user")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
	try {	if (userRepository.existsByUsername(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest().build();
		}
		signUpRequest.setExplanation("");
		signUpRequest.setRegType(ERole.FISHERMAN);
		SignUpRequest otherCheck =  requestRepository.save(signUpRequest);
		if(otherCheck!=null) {
			User user = new User(signUpRequest.getEmail(), 
					 signUpRequest.getPassword());
				Set<Role> userRole = new HashSet<>();
					userRole.add(roleRepository.findByName(ERole.FISHERMAN));
					user.setRoles(userRole);
			service.register(user, getSiteURL(request));
			return ResponseEntity.ok().build();
		}else return ResponseEntity.badRequest().build();
	}catch( DataIntegrityViolationException e) {
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
			
	}
	
	@PostMapping("/owner")
	public ResponseEntity<String> registerOwner(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
		if (userRepository.existsByUsername(signUpRequest.getEmail()) || signUpRequest.getExplanation().isBlank() || signUpRequest.getRegType()==null ) {
			return ResponseEntity
					.badRequest().build();
		}
		SignUpRequest otherCheck =  requestRepository.save(signUpRequest);
		if(otherCheck!=null) {
			User user = new User(signUpRequest.getEmail(), 
					 signUpRequest.getPassword());
				Set<Role> userRole = new HashSet<>();
					userRole.add(roleRepository.findByName(signUpRequest.getRegType()));
					user.setRoles(userRole);
			service.registerOwner(user, getSiteURL(request));
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
	 
	 @GetMapping("/requests")   
	 @PreAuthorize("hasAuthority('SYS_ADMIN')")
	 public ResponseEntity<List<SignUpRequest>> getRequests() {
		 	List<SignUpRequest> requests = requestRepository.findByRegTypeNotLike(ERole.FISHERMAN);
			if(requests.isEmpty() || requests==null) {
					return ResponseEntity.notFound().build();
				}
				return new ResponseEntity<List<SignUpRequest>>(requests, HttpStatus.OK);
			}
	 
	 
	 @PostMapping("/allow/{email}")
	 @PreAuthorize("hasAuthority('SYS_ADMIN')")
		public ResponseEntity<String> allow(@PathVariable String email) {
			SignUpRequest otherCheck =  requestRepository.getById(email);
			if (otherCheck==null) return ResponseEntity.notFound().build();
			if(service.allowOwner(otherCheck)) {
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.badRequest().build();
				
		}
	 
	 @PostMapping("/refuse")
	 @PreAuthorize("hasAuthority('SYS_ADMIN')")
		public ResponseEntity<String> refuse(@RequestParam("email") String email, @RequestParam("reason") String reason ) throws UnsupportedEncodingException, MessagingException {
			SignUpRequest otherCheck =  requestRepository.getById(email);
			if (otherCheck==null) return ResponseEntity.notFound().build();
			if(service.refuseOwner(otherCheck, reason))
			return ResponseEntity.ok().build();
			else return ResponseEntity.badRequest().build();
				
		}
	 

			
	 
	 @PostMapping("/admin")
	 @PreAuthorize("hasAuthority('SYS_ADMIN')")
		public ResponseEntity<String> registerAdmin(@Valid @RequestBody SignUpRequest signUpRequest,@RequestHeader("Authorization") String token ) throws UnsupportedEncodingException, MessagingException {
		 try {
		 String username =jwtUtils.getUserNameFromJwtToken(token.substring(6, token.length()).strip());
		 	if(!username.equals(System.getProperty("app.superadmin").toString())) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		 
		 if (userRepository.existsByUsername(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest().build();
			}
		 
				User user = new User(signUpRequest.getEmail(), 
						 "initial");
					Set<Role> userRole = new HashSet<>();
						userRole.add(roleRepository.findByName(ERole.SYS_ADMIN));
						user.setRoles(userRole);
				service.registerAdmin(user);
				
				 Admin admin = new Admin(signUpRequest);
				 adminRepo.save(admin);
				 
				return ResponseEntity.ok().build();
		 }catch(DataIntegrityViolationException e) {return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
		}
	 
	 
	 @PostMapping("/changePassword")
	 @PreAuthorize("hasAuthority('SYS_ADMIN') or hasAuthority('FISHERMAN')")
		public ResponseEntity<?> changePassword(@Valid @RequestBody PasswordChangeRequest passwordChange) throws URISyntaxException {
		 UserDetails user = service.loadUserByUsername(
			      SecurityContextHolder.getContext().getAuthentication().getName());
			    
			    if (!service.checkIfValidOldPassword(user, passwordChange.getOldPassword())) {
			       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			    }
			    service.changeUserPassword(user, passwordChange.getPassword());
				return new ResponseEntity<>(HttpStatus.OK);
				
		}
	 

}
	 