package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Diligence;

public interface DiligenceRepository extends JpaRepository<Diligence, Long>{
	List<Diligence> findByid(long id);
	List<Diligence> findByname(String name);
	List<Diligence> findBystatus(int status);
	List<Diligence> findByStatusAndProfileStatus(int status, int profileStatus);
}
