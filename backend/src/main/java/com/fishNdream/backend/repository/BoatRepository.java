package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.basic.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer>{

	
	

	
}
