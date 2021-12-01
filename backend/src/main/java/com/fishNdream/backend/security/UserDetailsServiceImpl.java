package com.fishNdream.backend.security;


import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.users.BoatOwner;
import com.fishNdream.backend.entity.users.CottageOwner;
import com.fishNdream.backend.entity.users.Fisherman;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.BoatOwnerRepository;
import com.fishNdream.backend.repository.CottageOwnerRepository;
import com.fishNdream.backend.repository.FishermanRepository;
import com.fishNdream.backend.repository.InstructorRepository;
import com.fishNdream.backend.repository.SignUpRequestRepository;
import com.fishNdream.backend.util.MailUtil;

import net.bytebuddy.utility.RandomString;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	FishermanRepository fishermanRepo;
	@Autowired
	private SignUpRequestRepository requestRepo;
	@Autowired
	private CottageOwnerRepository cottageOwnerRepo;
	@Autowired
	private InstructorRepository instructorRepo;
	@Autowired
	private BoatOwnerRepository boatOwnerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailUtil mailUtil;
     
    
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
	
		return UserDetailsImpl.build(user);
	}
	
	public void register(User user, String siteURL)
	        throws UnsupportedEncodingException, MessagingException {
	
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    String randomCode = RandomString.make(64);
	    user.setVerificationCode(randomCode);
	    user.setEnabled(false);
	     
	    userRepository.save(user);
	     
	    sendVerificationEmail(user, siteURL);
	}
	     
	private void sendVerificationEmail(User user, String siteURL)
	        throws MessagingException, UnsupportedEncodingException {
		
	   
	    mailUtil.sendVerificationEmail(user,siteURL);
	   
	     
	}
	public boolean verify(String verificationCode) {
	    User user = userRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setEnabled(true);
	        userRepository.save(user);
	        Optional<SignUpRequest> request = requestRepo.findById(user.getUsername());
	        Fisherman fisherman = new Fisherman(request.get());
	        fishermanRepo.save(fisherman);
	        requestRepo.deleteById(user.getUsername());
	        return true;
	    }
	     
	}
	
	public boolean checkIfValidOldPassword(UserDetails user, String oldPassword) {
		User old =userRepository.findByUsername(user.getUsername()).get();
		if(passwordEncoder.matches(oldPassword, old.getPassword())) return true;
		else return false;
		
	}

	public void changeUserPassword(UserDetails user, String password) {
		User old =userRepository.findByUsername(user.getUsername()).get();
		old.setPassword(passwordEncoder.encode(password));
		if(old.getVerificationCode().equals("initial")) old.setVerificationCode(null);
		userRepository.save(old);
		
	}

	public void registerAdmin(User user) {
		 String encodedPassword = passwordEncoder.encode(user.getPassword());
		    user.setPassword(encodedPassword);
		    user.setVerificationCode("initial");
		    user.setEnabled(true);		     
		    userRepository.save(user);
	}

	public void registerOwner(User user, String siteURL)
	        throws UnsupportedEncodingException, MessagingException {
	
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setEnabled(false);
	     
	    userRepository.save(user);
	     
	    sendVerificationEmail(user, siteURL);
	}

	public boolean allowOwner(SignUpRequest request) {
		Optional<User> user = userRepository.findByUsername(request.getEmail());
	     
	    if (user.get() == null || user.get().isEnabled()) {
	        return false;
	    } else {
	        user.get().setEnabled(true);
	        userRepository.save(user.get());
	       switch(request.getRegType()) {
	       case COTTAGE_OWNER:
	    	    CottageOwner owner = new CottageOwner(request);
		        cottageOwnerRepo.save(owner);
		        requestRepo.deleteById(request.getEmail());
		        mailUtil.sendAllowRegistrationMail(request);
		        return true;
	       case BOAT_OWNER:
	    	    BoatOwner bowner = new BoatOwner(request);
		        boatOwnerRepo.save(bowner);
		        requestRepo.deleteById(request.getEmail());
		        mailUtil.sendAllowRegistrationMail(request);
		        return true;
	       case INSTRUCTOR: 
	    	    Instructor instr = new Instructor(request);
		        instructorRepo.save(instr);
		        requestRepo.deleteById(request.getEmail());
		        mailUtil.sendAllowRegistrationMail(request);
		        return true;
	       default:
	    	   return false;
	       }
	       
	    }
		
	}

	public boolean refuseOwner(SignUpRequest request, String reason) throws UnsupportedEncodingException, MessagingException {
		Optional<User> user = userRepository.findByUsername(request.getEmail());
	     
	    if (user.get() == null || user.get().isEnabled()) {
	        return false;
	    } else {
	    	requestRepo.deleteById(request.getEmail());
	        userRepository.delete(user.get());
		    mailUtil.sendRefuseRegistrationMail(request, reason);
		    return true;   
	    }
	}

	public boolean isAdminsFirst(String username) {
		 Optional<User> user = userRepository.findByUsername(username);
		     if(user.get().getVerificationCode()==null) return false;
			 if(user.get().getVerificationCode().equals("initial"))
				 return true;
		return false;
	}


}
