package com.fishNdream.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationBoat;

@Repository
public interface ReservationBoatRepository extends JpaRepository<ReservationBoat, Integer> {

	Optional<ReservationBoat> findByReservationIdAndActionRes(int actionId, boolean b);

	
	

	
}