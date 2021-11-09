package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.users.Fisherman;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, String> {

	
	

	
}