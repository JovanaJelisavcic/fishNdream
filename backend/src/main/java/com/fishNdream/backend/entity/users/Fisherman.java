package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fishNdream.backend.entity.helper.ChangeInfoDTO;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.intercations.ReservationCottage;

@Entity
public class Fisherman extends UserInfo{
	
	@OneToMany(mappedBy="fisherman")
	private List<ReservationCottage> reservationCottages;
	@OneToMany(mappedBy="fisherman")
	private List<ReservationBoat> reservationBoats;
	
	public Fisherman(UserInfo user) {
		super(user);
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
}