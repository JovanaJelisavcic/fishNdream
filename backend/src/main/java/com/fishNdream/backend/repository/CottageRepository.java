package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.basic.Cottage;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Integer> {

	List<Cottage> findByAddressLikeIgnoreCaseOrNameLikeIgnoreCase(String string, String string2);

	
	

	
}
