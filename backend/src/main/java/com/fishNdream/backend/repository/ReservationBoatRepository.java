package com.fishNdream.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationBoat;

@Repository
public interface ReservationBoatRepository extends JpaRepository<ReservationBoat, Integer> {

	Optional<ReservationBoat> findByReservationIdAndActionRes(int actionId, boolean b);

	@Query(value="SELECT * FROM reservation_boat u WHERE u.boat_id = ?1 and u.email = ?2 and u.ending < CURDATE()", nativeQuery=true)
	Optional<ReservationBoat> findByBoatIdAndEmail(int boatId, String email);

	
	

	
}