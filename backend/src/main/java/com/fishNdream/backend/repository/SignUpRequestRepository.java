package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.SignUpRequest;

@Repository
public interface SignUpRequestRepository extends JpaRepository<SignUpRequest, String> {

	List<SignUpRequest> findByRegTypeNotLike(String string);

	
	

	
}

