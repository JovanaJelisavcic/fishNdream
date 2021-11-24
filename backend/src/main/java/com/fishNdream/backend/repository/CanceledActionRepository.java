package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.helper.CanceledAction;

@Repository
public interface CanceledActionRepository extends JpaRepository<CanceledAction, Integer> {

	
	

	
}
