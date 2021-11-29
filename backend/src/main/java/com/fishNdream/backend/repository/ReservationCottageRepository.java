package com.fishNdream.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationCottage;

@Repository
public interface ReservationCottageRepository extends JpaRepository<ReservationCottage, Integer> {

	Optional<ReservationCottage> findByReservationIdAndActionRes(int actionId, boolean b);
	@Query(value="Select COUNT(cottage_id) from reservation_cottage where cottage_id in (?1) and ending > CURDATE() and NOT canceled and email IS NOT NULL", nativeQuery=true)
	int hasOccupiedFuture(List<Integer> cottagesIds);
	
	@Query(value="Select COUNT(cottage_id) from reservation_cottage where ending > CURDATE() and NOT canceled and email=?1", nativeQuery=true)
	int hasPendingReservations(String email);

	
	

	
}
