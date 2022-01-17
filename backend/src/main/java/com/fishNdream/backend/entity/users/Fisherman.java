package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.ActionType;
import com.fishNdream.backend.entity.helper.CanceledAction;
import com.fishNdream.backend.entity.helper.ChangeInfoDTO;
import com.fishNdream.backend.entity.helper.DeleteAccountRequest;
import com.fishNdream.backend.entity.intercations.ReservationAdventure;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.ReservationCottage;
import com.fishNdream.backend.entity.intercations.SubscriptionBoat;
import com.fishNdream.backend.entity.intercations.SubscriptionCottage;
import com.fishNdream.backend.entity.intercations.SubscriptionInstructor;

@Entity
@SQLDelete(sql = "UPDATE fisherman SET deleted = true WHERE email=?")
@Where(clause = "deleted=false")
public class Fisherman extends UserInfo{
	
	@JsonView(Views.UserInfo.class)
	private int penalties;
	
	@OneToMany(mappedBy="fisherman", orphanRemoval=false)
	private List<ReservationCottage> reservationCottages;
	@OneToMany(mappedBy="fisherman", orphanRemoval=false)
	private List<ReservationBoat> reservationBoats;
	@OneToMany( mappedBy="fisherman", orphanRemoval=false)
	private List<ReservationAdventure> reservationAdventures;
	@OneToMany(
	        mappedBy = "fisherman"
	    )
	private List<SubscriptionCottage> subscriptionCotagges;
	@OneToMany(
	        mappedBy = "fisherman"
	    )
	private List<SubscriptionBoat> subsriptionsBoats;
	@OneToMany(
	        mappedBy = "fisherman"
	    )
	private List<SubscriptionInstructor> subscriptionInstructors;
	
	@OneToMany(mappedBy="fisherman")
	private List<CanceledAction> canceledActions;




	public Fisherman(UserInfo user) {
		super(user);
	}
	





	public Fisherman(List<ReservationCottage> reservationCottages, List<ReservationBoat> reservationBoats,
			List<ReservationAdventure> reservationAdventures, List<SubscriptionCottage> subscriptionCotagges,
			List<SubscriptionBoat> subsriptionsBoats, List<SubscriptionInstructor> subscriptionInstructors,
			List<CanceledAction> canceledActions, List<DeleteAccountRequest> deleteRqs) {
		super();
		this.reservationCottages = reservationCottages;
		this.reservationBoats = reservationBoats;
		this.reservationAdventures = reservationAdventures;
		this.subscriptionCotagges = subscriptionCotagges;
		this.subsriptionsBoats = subsriptionsBoats;
		this.subscriptionInstructors = subscriptionInstructors;
		this.canceledActions = canceledActions;
	}






	public List<CanceledAction> getCanceledActions() {
		return canceledActions;
	}



	public void setCanceledActions(List<CanceledAction> canceledActions) {
		this.canceledActions = canceledActions;
	}



	public List<SubscriptionInstructor> getSubscriptionInstructors() {
		return subscriptionInstructors;
	}



	public void setSubscriptionInstructors(List<SubscriptionInstructor> subscriptionInstructors) {
		this.subscriptionInstructors = subscriptionInstructors;
	}



	public List<SubscriptionCottage> getSubscriptionCotagges() {
		return subscriptionCotagges;
	}



	public void setSubscriptionCotagges(List<SubscriptionCottage> subscriptionCotagges) {
		this.subscriptionCotagges = subscriptionCotagges;
	}



	public List<SubscriptionBoat> getSubsriptionsBoats() {
		return subsriptionsBoats;
	}



	public void setSubsriptionsBoats(List<SubscriptionBoat> subsriptionsBoats) {
		this.subsriptionsBoats = subsriptionsBoats;
	}



	public List<ReservationCottage> getReservationCottages() {
		return reservationCottages;
	}


	public void setReservationCottages(List<ReservationCottage> reservationCottages) {
		this.reservationCottages = reservationCottages;
	}


	public List<ReservationBoat> getReservationBoats() {
		return reservationBoats;
	}


	public void setReservationBoats(List<ReservationBoat> reservationBoats) {
		this.reservationBoats = reservationBoats;
	}


	public List<ReservationAdventure> getReservationAdventures() {
		return reservationAdventures;
	}


	public void setReservationAdventures(List<ReservationAdventure> reservationAdventures) {
		this.reservationAdventures = reservationAdventures;
	}




	public Fisherman() {}
	public void changeUserInfo(@Valid ChangeInfoDTO user) {
		if(user.getAddress()!=null)
			if(!user.getAddress().equals(super.getAdress()))
				super.setAdress(user.getAddress());
		if(user.getCity()!=null)
			if(!user.getCity().equals(super.getCity()))
				super.setCity(user.getCity());
		if(user.getName()!=null)
			if(!user.getName().equals(super.getName()))
				super.setName(user.getName());
		if(user.getPhoneNum()!=null)
			if(!user.getPhoneNum().equals(super.getPhoneNum()))
				super.setPhoneNum(user.getPhoneNum());
		if(user.getState()!=null)
			if(!user.getState().equals(super.getState()))
				super.setState(user.getState());
		if(user.getSurname()!=null)
			if(!user.getSurname().equals(super.getSurname()))
				super.setSurname(user.getSurname());
		
		
		
	}
	public boolean alreadyReservedCottage(int entityId, LocalDateTime beginning, LocalDateTime ending) {
		for(ReservationCottage r : reservationCottages) {
			if(r.getCottage().getCottageId()==entityId && r.getBeginning().toLocalDate().equals(beginning.toLocalDate()) && r.getEnding().toLocalDate().equals(ending.toLocalDate()))
					return true;
		}
		return false;
	}
	public void addReservationCottage(ReservationCottage newReservation) {
		reservationCottages.add(newReservation);
		
	}
	public boolean alreadyReservedBoat(int entityId, LocalDateTime beginning, LocalDateTime ending) {
		for(ReservationBoat r : reservationBoats) {
			if(r.getBoat().getBoatId()==entityId && r.getBeginning().equals(beginning) && r.getEnding().equals(ending))
					return true;
		}
		return false;
	}
	public void addReservationBoat(ReservationBoat newReservation) {
		reservationBoats.add(newReservation);
		
	}
	public boolean alreadyReservedAdventure(int entityId, LocalDateTime beginning, LocalDateTime ending) {
		for(ReservationAdventure r : reservationAdventures) {
			if(r.getAdventure().getAdventureId()==entityId && r.getBeginning().equals(beginning) && r.getEnding().equals(ending))
					return true;
		}
		return false;
	}
	public void addReservationAdventure(ReservationAdventure newReservation) {
		reservationAdventures.add(newReservation);
		
	}
	public boolean alreadyReservedActionBoat(int reservationId) {
		for(CanceledAction r : canceledActions) {
			if(r.getActionId()==reservationId && r.getActionType().equals(ActionType.BOAT))
					return true;
		}
		return false;
	}



	public boolean alreadyReservedActionCottage(int reservationId) {
		for(CanceledAction r : canceledActions) {
			if(r.getActionId()==reservationId && r.getActionType().equals(ActionType.COTTAGE))
					return true;
		}
		return false;
	}



	public boolean alreadyReservedActionAdventure(int reservationId) {
		for(CanceledAction r : canceledActions) {
			if(r.getActionId()==reservationId && r.getActionType().equals(ActionType.ADVENTURE))
					return true;
		}
		return false;
	}



	public boolean alreadySubscribedCottage(int cottageId) {
		for(SubscriptionCottage s: subscriptionCotagges) {
			if(s.getCottage().getCottageId()==cottageId)
				return true;
		}
		return false;
	}



	public void addSubscriptionCottage(SubscriptionCottage newOne) {
		subscriptionCotagges.add(newOne);
		
	}



	public void removeSubscriptionCottage(int cottageId) {
		subscriptionCotagges.removeIf(s-> s.getCottage().getCottageId()==cottageId);
		
	}



	public boolean alreadySubscribedBoat(int boatId) {
		for(SubscriptionBoat s: subsriptionsBoats) {
			if(s.getBoat().getBoatId()==boatId)
				return true;
		}
		return false;
	}



	public void addSubscriptionBoat(SubscriptionBoat newOne) {
		subsriptionsBoats.add(newOne);
		
	}



	public void removeSubscriptionBoat(int boatId) {
		subsriptionsBoats.removeIf(s-> s.getBoat().getBoatId()==boatId);
		
	}



	public boolean alreadySubscribedInstructor(String email) {
		for(SubscriptionInstructor s: subscriptionInstructors) {
			if(s.getInstructor().getEmail()==email)
				return true;
		}
		return false;
	}



	public void addSubscriptionInstructor(SubscriptionInstructor newOne) {
		subscriptionInstructors.add(newOne);
		
	}



	public void removeSubscriptionInstructor(String email) {
		subscriptionInstructors.removeIf(s-> s.getInstructor().getEmail().equals(email));
		
	}



	public void cancelReservationCottage(int reservationId) {
		for(ReservationCottage s: reservationCottages) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}



	public void cancelReservationBoat(int reservationId) {
		for(ReservationBoat s: reservationBoats) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}



	public void cancelReservationAdventure(int reservationId) {
		for(ReservationAdventure s: reservationAdventures) {
			if(s.getReservationId()==reservationId)
				s.setCanceled(true);
		}
		
	}



	public void addCancelAction(CanceledAction action) {
	
		canceledActions.add(action);
	}



	public void removeFK() {
		canceledActions.forEach(a-> a.setFisherman(null));
		reservationAdventures.forEach(a->a.setFisherman(null));
		reservationBoats.forEach(a-> a.setFisherman(null));
		reservationCottages.forEach(a->a.setFisherman(null));
		subscriptionCotagges.forEach(a-> a.setFisherman(null));
		subscriptionInstructors.forEach(a-> a.setFisherman(null));
		subsriptionsBoats.forEach(a-> a.setFisherman(null));
		
		
	}






	public int getPenalties() {
		return penalties;
	}






	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	
}