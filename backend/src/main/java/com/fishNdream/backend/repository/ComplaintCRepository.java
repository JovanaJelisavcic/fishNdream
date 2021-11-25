package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.ComplaintCottage;

@Repository
public interface ComplaintCRepository extends JpaRepository<ComplaintCottage, Integer> {

	
	List<ComplaintCottage> findByResponseIsNull();

	
	

	
}
