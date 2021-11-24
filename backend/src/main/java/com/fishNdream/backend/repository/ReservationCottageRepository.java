package com.fishNdream.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationCottage;

@Repository
public interface ReservationCottageRepository extends JpaRepository<ReservationCottage, Integer> {

	Optional<ReservationCottage> findByReservationIdAndActionRes(int actionId, boolean b);

	
	

	
}
