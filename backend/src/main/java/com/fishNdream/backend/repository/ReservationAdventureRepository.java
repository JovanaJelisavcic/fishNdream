package com.fishNdream.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationAdventure;

@Repository
public interface ReservationAdventureRepository extends JpaRepository<ReservationAdventure, Integer> {

	Optional<ReservationAdventure> findByReservationIdAndActionRes(int actionId, boolean b);
	
	@Query(value="Select * from reservation_adventure where reservation_id NOT IN (SELECT reservation_id FROM revenue_item where res_type='ADVENTURE') and NOT canceled and email IS NOT NULL ", nativeQuery=true)
	List<ReservationAdventure> findUnrevenued();

	
	

	
}