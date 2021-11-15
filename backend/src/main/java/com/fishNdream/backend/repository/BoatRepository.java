package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.basic.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer>{

	List<Boat> findByNameLikeIgnoreCaseOrAddressLikeIgnoreCase(String string, String string2);

	
	

	
}
