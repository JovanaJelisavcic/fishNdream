package com.fishNdream.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fishNdream.backend.entity.intercations.SystemGain;

@Repository
public interface SysGainRepository extends JpaRepository<SystemGain,Integer> {

	@Query(value="SELECT percentage FROM system_gain WHERE ending > CURDATE() order by beginning DESC limit 1", nativeQuery=true)
	float getLatestGain();

	@Query(value="SELECT * FROM system_gain WHERE ending > CURDATE() order by beginning DESC limit 1", nativeQuery=true)
	SystemGain getLatest();


}
