package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc6;

public interface FinDoc6Repository extends JpaRepository<FinDoc6, Long>{
	List<FinDoc6> findBydiligenceId(int dilId);
}