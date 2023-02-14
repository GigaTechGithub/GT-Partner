package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc10;

public interface FinDoc10Repository extends JpaRepository<FinDoc10, Long>{
	List<FinDoc10> findBydiligenceId(int dilId);
}

