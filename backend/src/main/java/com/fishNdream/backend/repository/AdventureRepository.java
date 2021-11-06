package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.basic.Adventure;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {

	
	

	
}
