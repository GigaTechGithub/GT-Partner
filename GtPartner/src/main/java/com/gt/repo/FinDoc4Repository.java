package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc4;

public interface FinDoc4Repository extends JpaRepository<FinDoc4, Long>{
	List<FinDoc4> findBydiligenceId(int dilId);
}