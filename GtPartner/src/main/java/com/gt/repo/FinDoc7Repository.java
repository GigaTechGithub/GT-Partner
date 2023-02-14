package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc7;

public interface FinDoc7Repository extends JpaRepository<FinDoc7, Long>{
	List<FinDoc7> findBydiligenceId(int dilId);
}