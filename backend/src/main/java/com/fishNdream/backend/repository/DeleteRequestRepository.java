package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.helper.DeleteAccountRequest;

@Repository
public interface DeleteRequestRepository extends JpaRepository<DeleteAccountRequest, Integer> {
	
	
	@Query(value="SELECT * FROM DELETE_ACCOUNT_REQUEST where processed='false'", nativeQuery=true)
	List<DeleteAccountRequest> getByProcessed();


	
	

	
}
