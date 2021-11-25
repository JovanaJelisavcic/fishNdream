package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ComplaintBoat;

@Repository
public interface ComplaintBRepository extends JpaRepository<ComplaintBoat, Integer> {

	List<ComplaintBoat> findByResponseIsNull();

	
	

	
}