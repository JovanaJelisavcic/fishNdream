package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.users.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String> {

	
	

	
}