package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.SignUpRequest;
import com.fishNdream.backend.security.ERole;

@Repository
public interface SignUpRequestRepository extends JpaRepository<SignUpRequest, String> {

	List<SignUpRequest> findByRegTypeNotLike(ERole fisherman);

	
	

	
}

