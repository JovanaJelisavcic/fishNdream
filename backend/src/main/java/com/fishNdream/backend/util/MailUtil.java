package com.fishNdream.backend.util;


import java.io.UnsupportedEncodingException;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.helper.DeleteAccountRequest;
import com.fishNdream.backend.entity.helper.DeleteAccountRequestAdmin;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.intercations.ComplaintBoat;
import com.fishNdream.backend.entity.intercations.ComplaintCottage;
import com.fishNdream.backend.entity.intercations.ComplaintInstructor;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
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

		public void sendReservationCottageConfirmation(String email, ReservationCottage newReservation) throws MessagingException, UnsupportedEncodingException {
			 String toAddress = newReservation.getFisherman().getEmail();
			    String subject = "Cottage Reservation Confirmation";
			    String content = "Dear [[name]],<br>"
			            + "You successfully reserved the cottage with following information :<br>"
			            + "cottage name : [[cottageName]] <br>"
			            + "Check In Date : [[beginning]] <br>"
			            + "Check Out Date : [[ending]] <br>"
			            + "<br>for [[guestNum]] people <br>"
			            + "<br> It was [[action]] done over action <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", newReservation.getFisherman().getSurname());
			    content = content.replace("[[cottageName]]", newReservation.getCottage().getName());
			    content = content.replace("[[beginning]]", newReservation.getBeginning().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			    content = content.replace("[[ending]]", newReservation.getEnding().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			    content = content.replace("[[guestNum]]", String.valueOf(newReservation.getParticipantsNum()));
			    content = content.replace("[[action]]", newReservation.isActionRes()?"":"not");
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}

		public void sendReservationBoatConfirmation(String email, ReservationBoat newReservation) throws UnsupportedEncodingException, MessagingException {
			 String toAddress = newReservation.getFisherman().getEmail();
			    String subject = "Boat Reservation Confirmation";
			    String content = "Dear [[name]],<br>"
			            + "You successfully reserved the boat with following information :<br>"
			            + "boat name : [[boatName]] <br>"
			            + "Check In Date And Time : [[beginning]] <br>"
			            + "Check Out Date And Time : [[ending]] <br>"
			            + "<br>for [[guestNum]] people. <br>"
			            + "<br> It was [[action]] done over action <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", newReservation.getFisherman().getSurname());
			    content = content.replace("[[boatName]]", newReservation.getBoat().getName());
			    content = content.replace("[[beginning]]", newReservation.getBeginning().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
			    content = content.replace("[[ending]]", newReservation.getEnding().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
			    content = content.replace("[[guestNum]]", String.valueOf(newReservation.getParticipantsNum()));
			    content = content.replace("[[action]]", newReservation.isActionRes()?"":"not");
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}

		public void sendReservationAdventureConfirmation(String email, ReservationAdventure newReservation) throws UnsupportedEncodingException, MessagingException {
			
			 String toAddress = newReservation.getFisherman().getEmail();
			    String subject = "Adventure Reservation Confirmation";
			    String content = "Dear [[name]],<br>"
			            + "You successfully reserved the adventure with following information :<br>"
			            + "Adventure name : [[adventureName]] <br>"
			            + "Check In Date And Time : [[beginning]] <br>"
			            + "Check Out Date And Time : [[ending]] <br>"
			            + "<br>for [[guestNum]] people <br>"
			            + "<br> It was [[action]] done over action <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", newReservation.getFisherman().getSurname());
			    content = content.replace("[[adventureName]]", newReservation.getAdventure().getName());
			    content = content.replace("[[beginning]]", newReservation.getBeginning().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
			    content = content.replace("[[ending]]", newReservation.getEnding().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
			    content = content.replace("[[guestNum]]", String.valueOf(newReservation.getParticipantsNum()));
			    content = content.replace("[[action]]", newReservation.isActionRes()?"":"not");
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
		}


		public void sendComplainResponseC(ComplaintCottage complaint) throws MessagingException, UnsupportedEncodingException {

			 String toAddress1 = complaint.getFisherman().getEmail();
			 String toAddress2 = complaint.getCottage().getOwner().getEmail();
			    String subject = "Complaint Response";
			    String content = "Dear [[name]],<br>"
			            + "The complaint was :<br>"
			            + "[[complaint]] <br>"
			            + "<br>We have reviewed and decided that <br>"
			            + "<br> [[response]]  <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress1);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", complaint.getFisherman().getSurname());
			    content = content.replace("[[complaint]]", complaint.getComplaintText());
			    content = content.replace("[[response]]", complaint.getResponse());
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			    
			    content = content.replace("[[name]]", complaint.getCottage().getOwner().getSurname());
			    helper.setTo(toAddress2);
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}

		public void sendComplainResponseB(ComplaintBoat complaint) throws UnsupportedEncodingException, MessagingException {
			 String toAddress1 = complaint.getFisherman().getEmail();
			 String toAddress2 = complaint.getBoat().getOwner().getEmail();
			    String subject = "Complaint Response";
			    String content = "Dear [[name]],<br>"
			            + "The complaint was :<br>"
			            + "[[complaint]] <br>"
			            + "<br>We have reviewed and decided that <br>"
			            + "<br> [[response]]  <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress1);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", complaint.getFisherman().getSurname());
			    content = content.replace("[[complaint]]", complaint.getComplaintText());
			    content = content.replace("[[response]]", complaint.getResponse());
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			    
			    content = content.replace("[[name]]", complaint.getBoat().getOwner().getSurname());
			    helper.setTo(toAddress2);
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}

		public void sendComplainResponseI(ComplaintInstructor complaint) throws UnsupportedEncodingException, MessagingException {
			String toAddress1 = complaint.getFisherman().getEmail();
			 String toAddress2 = complaint.getInstructor().getEmail();
			    String subject = "Complaint Response";
			    String content = "Dear [[name]],<br>"
			            + "The complaint was :<br>"
			            + "[[complaint]] <br>"
			            + "<br>We have reviewed and decided that <br>"
			            + "<br> [[response]]  <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress1);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", complaint.getFisherman().getSurname());
			    content = content.replace("[[complaint]]", complaint.getComplaintText());
			    content = content.replace("[[response]]", complaint.getResponse());
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			    
			    content = content.replace("[[name]]", complaint.getInstructor().getSurname());
			    helper.setTo(toAddress2);
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
		}

		public void sendDeletionResponse(DeleteAccountRequest req) throws UnsupportedEncodingException, MessagingException {
			 String toAddress = req.getFisherman().getEmail();
			    String subject = "Account Deletion Response";
			    String content = "Dear [[name]],<br>"
			            + "Your request for deleting you account was [[permited]] permited. <br>"
			            + " [[reason]] <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", req.getFisherman().getSurname());
			    content = content.replace("[[reason]]", req.getResponse());
			    content = content.replace("[[permited]]", req.isPermited()?"":"not");
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}

		public void sendDeletionResponse(DeleteAccountRequestAdmin req) throws UnsupportedEncodingException, MessagingException {
			 String toAddress = req.getAdmin().getEmail();
			    String subject = "Account Deletion Response";
			    String content = "Dear [[name]],<br>"
			            + "Your request for deleting you account was [[permited]] permited. <br>"
			            + " [[reason]] <br>"
			            + "<br>Thank you for trusting us,<br>"
			            + "fishNdream.";
			     
			    MimeMessage message = javaMailSender.createMimeMessage();
			    MimeMessageHelper helper = new MimeMessageHelper(message);
			     
			    helper.setFrom(fromAddress, senderName);
			    helper.setTo(toAddress);
			    helper.setSubject(subject);
			     
			    content = content.replace("[[name]]", req.getAdmin().getSurname());
			    content = content.replace("[[reason]]", req.getResponse());
			    content = content.replace("[[permited]]", req.isPermited()?"":"not");
			    helper.setText(content, true);
			     
			    javaMailSender.send(message);
			
		}    
	    
	

	
	
	

	

	

}
