package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc13;

public interface FinDoc13Repository extends JpaRepository<FinDoc13, Long>{
	List<FinDoc13> findBydiligenceId(int dilId);
}

