package com.fishNdream.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.helper.DeleteAccountRequestAdmin;

@Repository
public interface DeteleRequestARepository extends JpaRepository<DeleteAccountRequestAdmin, Integer> {
	
	
	@Query(value="SELECT * FROM DELETE_ACCOUNT_REQUEST_ADMIN where processed='false'", nativeQuery=true)
	List<DeleteAccountRequestAdmin> getByProcessed();


	
	

	
}