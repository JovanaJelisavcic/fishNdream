package com.fishNdream.backend.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.users.Instructor;

@Component
public class FilteringUtil {
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
			if(b.getAddress().toUpperCase().contains(location.toUpperCase())) result.add(b);
			else {
				if(guestsNum!=0 && b.getCapacity()>=guestsNum) result.add(b);
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
			if(c.getAddress().toUpperCase().contains(location.toUpperCase())) result.add(c);
			else {
				if(guests!=0 && c.getGuestsNum()>=guests) result.add(c);
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

		return result;
	}

	public List<Adventure> getAdventuresOnLocationAndGuests(List<Adventure> available, String location, int guestsNum) {
		List<Adventure> result = new ArrayList<>();
		for(Adventure a : available) {
			if(a.getAddress().toUpperCase().contains(location.toUpperCase())) result.add(a);
			else {
				if(guestsNum!=0 && a.getMaxParticipants()>=guestsNum) result.add(a);
			}
		}
		return result;
	}

}