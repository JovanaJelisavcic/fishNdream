package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationAdventure;

@Repository
public interface ReservationAdventureRepository extends JpaRepository<ReservationAdventure, Integer> {

	
	

	
}