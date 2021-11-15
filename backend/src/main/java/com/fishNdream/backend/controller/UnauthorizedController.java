package com.fishNdream.backend.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.users.Instructor;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.repository.InstructorRepository;
import com.fishNdream.backend.util.FilteringUtil;




@RestController
@RequestMapping("/unautho")
public class UnauthorizedController {

	@Autowired
	CottageRepository cottageRepo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	InstructorRepository instructorRepo;
	@Autowired
	FilteringUtil filteringUtil;
	
	
	@JsonView(Views.UnauthoCottages.class)
	@GetMapping("/cottages")
	public List<Cottage> getCottages() {
		return  cottageRepo.findAll();
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@GetMapping("/boats")
	public List<Boat> getBoats() {
		return boatRepo.findAll();
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@GetMapping("/instructors")
	public List<Instructor> getAdventures() {
		return instructorRepo.findAll();
	}
	
	@JsonView(Views.UnauthoCottages.class)
	@GetMapping("/cottages/{id}")
	public ResponseEntity<Cottage> getCottage(@PathVariable int id) {
		Optional<Cottage> cottage =  cottageRepo.findById(id);
		if(cottage.isEmpty()) return ResponseEntity.notFound().build();
		return new ResponseEntity<Cottage>(cottage.get(), HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@GetMapping("/boats/{id}")
	public ResponseEntity<Boat> getBoat(@PathVariable int id) {
		Optional<Boat> boat =  boatRepo.findById(id);
		if(boat.isEmpty()) return ResponseEntity.notFound().build();
		return new ResponseEntity<Boat>(boat.get(), HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@GetMapping("/instructors/{id}")
	public ResponseEntity<Instructor> getAdventure(@PathVariable String id) {
		Optional<Instructor> instruct =  instructorRepo.findById(id);
		if(instruct.isEmpty()) return ResponseEntity.notFound().build();
		return new ResponseEntity<Instructor>(instruct.get(), HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoCottages.class)
	@GetMapping(value="/cottages/search/{criteria}")
	public ResponseEntity<List<Cottage>> searchCottageByNameOrPlace(@PathVariable String criteria){
		 StringBuilder sb = new StringBuilder(criteria.concat("%"));
		 sb.insert(0,"%");
		List<Cottage> ctgs = cottageRepo.findByAddressLikeIgnoreCaseOrNameLikeIgnoreCase(sb.toString(), sb.toString());
		if(ctgs.isEmpty() || ctgs==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Cottage>>(ctgs, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@GetMapping(value="/boats/search/{name}")
	public ResponseEntity<List<Boat>> searchBoatsByNameOrPlace(@PathVariable String name){
		 StringBuilder sb = new StringBuilder(name.concat("%"));
		 sb.insert(0,"%");
		List<Boat> boats = boatRepo.findByNameLikeIgnoreCaseOrAddressLikeIgnoreCase(sb.toString(), sb.toString());
		if(boats.isEmpty() || boats==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Boat>>(boats, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@GetMapping(value="/instructors/search/{name}")
	public ResponseEntity<List<Instructor>> searchInstructorByNameOrAdventure(@PathVariable String name){
		 StringBuilder sb = new StringBuilder(name.concat("%"));
		 sb.insert(0,"%");
		List<Instructor> instr = instructorRepo.findAll();
		if(instr.isEmpty() || instr==null) {
			return ResponseEntity.notFound().build();
		}
		List<Instructor> filtered = filteringUtil.filterInstructors(instr, name);
		if(filtered.isEmpty()) return ResponseEntity.notFound().build();
		return new ResponseEntity<List<Instructor>>(filtered, HttpStatus.OK);
	}


	
}
