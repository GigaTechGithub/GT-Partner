package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc2;

public interface FinDoc2Repository extends JpaRepository<FinDoc2, Long>{
	List<FinDoc2> findBydiligenceId(int dilId);
}
