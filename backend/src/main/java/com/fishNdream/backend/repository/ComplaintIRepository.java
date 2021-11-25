package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ComplaintInstructor;


@Repository
public interface ComplaintIRepository extends JpaRepository<ComplaintInstructor, Integer> {

	List<ComplaintInstructor> findByResponseIsNull();

	
	

	
}