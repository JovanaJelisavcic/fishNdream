package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.intercations.ReservationBoat;

@Entity
public class BoatOwner extends UserInfo {
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, targetEntity = Boat.class)
	private List<Boat> boats;
	


	public BoatOwner(SignUpRequest request) {
		super(request.getEmail(), request.getName(),request.getSurname(), request.getAdress(), request.getCity(), request.getState(),
				request.getPhoneNum());
	}
	
	public BoatOwner() {}

	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}



	public boolean checkIfAvailableForService(LocalDateTime beginning, LocalDateTime ending) {
		for(Boat boat : boats) {
			if(!boat.isAvailableAndFree(beginning, ending)) {
				for(ReservationBoat reserv: boat.getReservations()) {
					if(!(      (beginning.isBefore(reserv.getBeginning()) && ending.isBefore(reserv.getBeginning()))    || 
							(beginning.isAfter(reserv.getEnding()) && ending.isAfter(reserv.getEnding()))  )
							&& !reserv.isCanceled() && reserv.getFisherman()!=null) {
						if(reserv.isCaptainBusy(beginning, ending)) return false;
					}
					
				}
			}
		}
		return true;
	} 
	
	

}
