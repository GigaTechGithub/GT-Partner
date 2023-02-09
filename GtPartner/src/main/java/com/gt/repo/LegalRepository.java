package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Legal;

public interface LegalRepository extends JpaRepository<Legal, Long>{
	List<Legal> findBydiligenceId(int dilId);
}

