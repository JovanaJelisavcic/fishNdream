package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.helper.RevenueItem;

@Repository
public interface RevenueRepository extends JpaRepository<RevenueItem, Integer> {

	

	
	

	
}