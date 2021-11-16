package com.fishNdream.backend.util;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.repository.SignUpRequestRepository;
import com.fishNdream.backend.security.User;

@Component
public class MailUtil {
	
	   @Autowired
	    private JavaMailSender javaMailSender;
	   
	   String fromAddress = "jelisavcicjovana@gmail.com";
	    String senderName = "fishNdream";

	    @Autowired
		private SignUpRequestRepository requestRepo;
	    
	    public void sendVerificationEmail(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
			
	    	 String toAddress = user.getUsername();
	 	    String fromAddress = "jelisavcicjovana@gmail.com";
	 	    String senderName = "fishNdream";
	 	    String subject = "Please verify your registration";
	 	    String content = "Dear [[name]],<br>"
	 	            + "Please click the link below to verify your registration:<br>"
	 	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	 	            + "Thank you,<br>"
	 	            + "Farmacia.";
	 	     
	 	    MimeMessage message = javaMailSender.createMimeMessage();
	 	    MimeMessageHelper helper = new MimeMessageHelper(message);
	 	     
	 	    helper.setFrom(fromAddress, senderName);
	 	    helper.setTo(toAddress);
	 	    helper.setSubject(subject);
	 	     
	 	    content = content.replace("[[name]]", requestRepo.findById(user.getUsername()).get().getSurname());
	 	    String verifyURL = siteURL + "/register/verify?code=" + user.getVerificationCode();
	 	     
	 	    content = content.replace("[[URL]]", verifyURL);
	 	     
	 	    helper.setText(content, true);
	 	     
	 	   javaMailSender.send(message);
			
		}

		public void sendAllowRegistrationMail(SignUpRequest request) {
			SimpleMailMessage msg = new SimpleMailMessage();
			 msg.setTo(request.getEmail());
			 msg.setFrom(fromAddress);
			 msg.setSubject("fishNdream Registration");
			 msg.setText("Glad to inform you that your registration went well. Have fun fishin' an' dreamin'!");
			 javaMailSender.send(msg);			
			
		}

		public void sendRefuseRegistrationMail(SignUpRequest request, String reason) throws MessagingException, UnsupportedEncodingException {
			 String toAddress = request.getEmail();
			    String subject = "Answer to your registration request";
			    String content = "Dear [[name]],<br>"
			            + "We are sorry to inform you that your registration request has been denied for next reason:<br>"
			            + "[[reason]]"
			            + "<br>Thank you for understanding,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", request.getSurname());
			   
			     
			    content = content.replace("[[reason]]", reason);
			     
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}    
	    
	
/*
	public void sendDenyVacation(VacationPharmacist vacationPharmacist) throws MessagingException, UnsupportedEncodingException {
		  String toAddress = vacationPharmacist.getPharmacist().getEmail();
		    String senderName = "Farmacia";
		    String subject = "Answer to your vacation request";
		    String content = "Dear [[name]],<br>"
		            + "I am sorry to inform you that your vacation request has been denied for next reason:<br>"
		            + "[[reason]]"
		            + "<br>Thank you for understanding,<br>"
		            + "Farmacia.";
		     
		    MimeMessage message = javaMailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		     
		    helper.setFrom(fromAddress, senderName);
		    helper.setTo(toAddress);
		    helper.setSubject(subject);
		     
		    content = content.replace("[[name]]", vacationPharmacist.getPharmacist().getSurname());
		   
		     
		    content = content.replace("[[reason]]", vacationPharmacist.getExplanation());
		     
		    helper.setText(content, true);
		     
		    javaMailSender.send(message);
		
	}*/
	
	
	

	

	

}
