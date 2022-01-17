package com.fishNdream.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ReservationBoat;

@Repository
public interface ReservationBoatRepository extends JpaRepository<ReservationBoat, Integer> {

	Optional<ReservationBoat> findByReservationIdAndActionRes(int actionId, boolean b);

	@Query(value="SELECT * FROM reservation_boat u WHERE u.boat_id = ?1 and u.email = ?2 and u.ending < NOW()", nativeQuery=true)
	List<ReservationBoat> findByBoatIdAndEmail(int boatId, String email);

	@Query(value="Select COUNT(boat_id) from reservation_boat where boat_id in (?1) and ending > NOW() and NOT canceled and email IS NOT NULL", nativeQuery=true)
	int hasOccupiedFuture(List<Integer> boatsIds);

	@Query(value="Select COUNT(boat_id) from reservation_boat where ending > NOW() and NOT canceled and email=?1", nativeQuery=true)
	int hasPendingReservations(String email);

	@Query(value="Select * from reservation_boat where reservation_id NOT IN (SELECT reservation_id FROM revenue_item where res_type='BOAT') and ending <= NOW() and NOT canceled and email IS NOT NULL ", nativeQuery=true)
	List<ReservationBoat> findUnrevenued();


	
}