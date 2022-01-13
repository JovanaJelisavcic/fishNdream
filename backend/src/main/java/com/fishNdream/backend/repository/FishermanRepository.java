package com.fishNdream.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.users.Fisherman;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, String> {
	@Query(value="SELECT * FROM FISHERMAN where EMAIL=?1", nativeQuery=true)
	Optional<Fisherman> findByEmail(String username);

	
	

	
}