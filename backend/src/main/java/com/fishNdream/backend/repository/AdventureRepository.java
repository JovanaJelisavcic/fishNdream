package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.basic.Adventure;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {

	@Query(value="Select COUNT(adventure_id) from reservation_adventure where adventure_id in (?1) and ending > NOW() and NOT canceled and email IS NOT NULL", nativeQuery=true)
	int hasOccupiedFuture(List<Integer> adventureIds);

	@Query(value="Select COUNT(adventure_id) from reservation_adventure where ending > NOW() and NOT canceled and email=?1", nativeQuery=true)
	int hasPendingReservations(String email);

	
	

	
}
