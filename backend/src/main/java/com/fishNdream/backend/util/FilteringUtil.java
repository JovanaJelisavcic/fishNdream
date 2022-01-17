package com.fishNdream.backend.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.intercations.ReservationBoat;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.ReservationBoatRepository;

@Component
public class FilteringUtil {
	
	@Autowired
	ReservationBoatRepository resBRepo;
	//private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	public FilteringUtil() {}

	public List<Instructor> filterInstructors(List<Instructor> instr, String criteria) {
		List<Instructor> filtered = new ArrayList<>();
		for(Instructor inst : instr) {
			if(inst.getName().toUpperCase().contains(criteria.toUpperCase()) || inst.getSurname().toUpperCase().contains(criteria.toUpperCase()))
				filtered.add(inst);
			else {
				for(Adventure adv : inst.getAdventures()) {
					if(adv.getName().toUpperCase().contains(criteria.toUpperCase()) || adv.getAddress().toUpperCase().contains(criteria.toUpperCase()))
						filtered.add(inst);
				}
			}
		}
		return filtered;
	}
	
	public List<Boat> getBoatsOnLocationAndGuests(List<Boat> available, String location, int guestsNum) {
		List<Boat> result = new ArrayList<>();
		for(Boat b : available) {
			
			if(location.isEmpty() || b.getAddress().toUpperCase().contains(location.toUpperCase())) { 

				if(b.getCapacity()>=guestsNum) {
					result.add(b);
				}
					
				}
		}
		return result;
	}


	public List<Boat> getAvaiableBoats(List<Boat> boats, LocalDateTime from, LocalDateTime to) {
		List<Boat> result = new ArrayList<>();
		for(Boat b : boats) {
			if(b.isAvailableAndFree(from,to)) result.add(b);
			}

		return result;
	}


	public List<Cottage> getCottagesOnLocationAndGuests(List<Cottage> available, String location, int guests) {
		List<Cottage> result = new ArrayList<>();
		for(Cottage c : available) {
			if(location.isEmpty() || c.getAddress().toUpperCase().contains(location.toUpperCase())) {
				if(c.getGuestsNum()>=guests) {
					result.add(c);
				}
			} 
		}
		return result;
	}
	
	

	public List<Cottage> getAvaiableCottages(List<Cottage> cottages, LocalDateTime from, LocalDateTime to) {
		List<Cottage> result = new ArrayList<>();
		for(Cottage c : cottages) {
			if(c.isAvailableAndFree(from,to)) { 
				result.add(c);
				}
			}

		return result;
	}

	public List<Adventure> getAvaiableAdventures(List<Adventure> adventures, LocalDateTime from, LocalDateTime to) {
		List<Adventure> result = new ArrayList<>();
		for(Adventure a : adventures) {
			if(a.isAvailableAndFreeWithInstructor(from,to)) result.add(a);
			}
		System.out.println("available bude " + result.size());
		return result;
	}

	public List<Adventure> getAdventuresOnLocationAndGuests(List<Adventure> available, String location, int guestsNum) {
		List<Adventure> result = new ArrayList<>();
		for(Adventure a : available) {
			if(location.isEmpty() || a.getAddress().toUpperCase().contains(location.toUpperCase())) {
				if(a.getMaxParticipants()>=guestsNum) {
					result.add(a);
				}
					
			}
				
			}
		
		return result;
	}

	public List<Cottage> onlyPossibleCottageComplaints(List<Cottage> cottages, String username) {
		List<Cottage> result = new ArrayList<>();
		for(Cottage c : cottages) {
			if(c.atLeastOnceReserved(username) && !c.alreadyComplained(username)) { 
				result.add(c);
				}
			}

		return result;
	}

	public List<Boat> onlyPossibleBoatComplaints(List<Boat> boats, String username) {
		List<Boat> result = new ArrayList<>();
		for(Boat c : boats) {
			if(!c.alreadyComplained(username)) { 
				List<ReservationBoat> r = resBRepo.findByBoatIdAndEmail(c.getBoatId(), username);
				if(!r.isEmpty()) {result.add(c);}
				
				}
			}

		return result;
	}

	public List<Instructor> onlyPossibleInstructorComplaints(List<Instructor> instrs, String username) {
		List<Instructor> result = new ArrayList<>();
		for(Instructor c : instrs) {
			if(c.atLeastOnceReserved(username) && !c.alreadyComplained(username)) { 
				result.add(c);
				}
			}

		return result;
	}



}