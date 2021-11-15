package com.fishNdream.backend.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.users.Instructor;

@Component
public class FilteringUtil {
	
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
	
	

}