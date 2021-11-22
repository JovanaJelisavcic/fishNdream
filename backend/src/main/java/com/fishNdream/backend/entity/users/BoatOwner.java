package com.fishNdream.backend.entity.users;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.helper.AdditionalServicesBoat;
import com.fishNdream.backend.entity.helper.SignUpRequest;
import com.fishNdream.backend.entity.intercations.ReservationBoat;

@Entity
public class BoatOwner extends UserInfo {
//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BoatOwner.class);
	
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
			
			
				if(boat.getReservations()==null) return true;
				for(ReservationBoat reserv: boat.getReservations()) {
			
					if(!(      (beginning.isBefore(reserv.getBeginning()) && ending.isBefore(reserv.getBeginning()))    || 
							(beginning.isAfter(reserv.getEnding()) && ending.isAfter(reserv.getEnding()))  )
							&& !reserv.isCanceled() && reserv.getFisherman()!=null) {
						if(reserv.isCaptainBusy(beginning, ending)) return false;
					}
					
				}
		}
		return true;
	}
	//return reservations.removeIf(r -> ( !(      (from.isBefore(r.getBeginning()) && to.isBefore(r.getBeginning()))    ||     (from.isAfter(r.getEnding()) && to.isAfter(r.getEnding()))  ) && r.isActionRes() && r.getFisherman()==null ));
	
	public Boat removeAction(LocalDateTime from, LocalDateTime to) {
		for(Boat b : boats) {
			boolean removed = false;
			for(ReservationBoat r : b.getReservations()) {
				if(!(      (from.isBefore(r.getBeginning()) && to.isBefore(r.getBeginning()))    ||     (from.isAfter(r.getEnding()) && to.isAfter(r.getEnding()))  ) && r.isActionRes() && r.getFisherman()==null ) {
					for(AdditionalServicesBoat a: r.getAdditionalServices()) {
						if(a.getName().toUpperCase().contains("Capetain".toUpperCase())) {
							b.removeReservation(r);
							removed=true;
						}
						
					}

				}
			}
			if(removed) return b;
		}
		return null;
	} 
	
	

}
