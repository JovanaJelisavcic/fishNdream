package com.fishNdream.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fishNdream.backend.entity.basic.Adventure;
import com.fishNdream.backend.entity.basic.Boat;
import com.fishNdream.backend.entity.basic.Cottage;
import com.fishNdream.backend.entity.basic.Views;
import com.fishNdream.backend.entity.helper.SerachDTO;
import com.fishNdream.backend.repository.AdventureRepository;
import com.fishNdream.backend.repository.BoatRepository;
import com.fishNdream.backend.repository.CottageRepository;
import com.fishNdream.backend.util.FilteringUtil;


@RestController
@RequestMapping("/search")
public class SearchController {
//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	CottageRepository cottagesRepo;
	@Autowired
	BoatRepository boatRepo;
	@Autowired
	AdventureRepository adventureRepo;

	@Autowired
	FilteringUtil filterUtil;


	@JsonView(Views.UnauthoCottages.class)
	@RequestMapping(path = "/cottages", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE, 
    method = { RequestMethod.POST})
	public ResponseEntity<?> freeCottages( @Valid @RequestBody SerachDTO search )  {
		List<Cottage> cottages =  cottagesRepo.findAll();
		List<Cottage> available = filterUtil.getAvaiableCottages(cottages, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) available = filterUtil.getCottagesOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoBoats.class)
	@PostMapping("/boats")
	public ResponseEntity<?> freeBoats(@Valid  @RequestBody SerachDTO search )  {	
		List<Boat> boats =  boatRepo.findAll();
		List<Boat> available = filterUtil.getAvaiableBoats(boats, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) available = filterUtil.getBoatsOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}
	
	@JsonView(Views.UnauthoInstuctors.class)
	@PostMapping("/adventures")
	public ResponseEntity<?> freeAdventures(@Valid  @RequestBody SerachDTO search )  {	
		List<Adventure> adventures =  adventureRepo.findAll();
		List<Adventure> available = filterUtil.getAvaiableAdventures(adventures, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) {
			available = filterUtil.getAdventuresOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		} 
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}
	
	
	
	@JsonView(Views.CottageProfile.class)
	@RequestMapping(path = "/cottages/fisher", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE, 
    method = { RequestMethod.POST})
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeCottagesF( @Valid @RequestBody SerachDTO search )  {
		List<Cottage> cottages =  cottagesRepo.findAll();
		List<Cottage> available = filterUtil.getAvaiableCottages(cottages, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) available = filterUtil.getCottagesOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}
	
	@JsonView(Views.BoatProfile.class)
	@PostMapping("/boats/fisher")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeBoatsF(@Valid  @RequestBody SerachDTO search )  {	
		List<Boat> boats =  boatRepo.findAll();
		List<Boat> available = filterUtil.getAvaiableBoats(boats, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) available = filterUtil.getBoatsOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}
	
	@JsonView(Views.InstructorProfile.class)
	@PostMapping("/adventures/fisher")
	@PreAuthorize("hasAuthority('FISHERMAN')")
	public ResponseEntity<?> freeAdventuresF(@Valid  @RequestBody SerachDTO search )  {	
		List<Adventure> adventures =  adventureRepo.findAll();
		List<Adventure> available = filterUtil.getAvaiableAdventures(adventures, search.getDateTime(),search.getEndTime());
		if(search.getLocation()!=null || search.getGuestsNum()!=0) {
			available = filterUtil.getAdventuresOnLocationAndGuests(available, search.getLocation(), search.getGuestsNum());
		} 
		if(available.isEmpty() ) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<>(available, HttpStatus.OK);
	}

	
	
	
}
