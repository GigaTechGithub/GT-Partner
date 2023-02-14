package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc12;

public interface FinDoc12Repository extends JpaRepository<FinDoc12, Long>{
	List<FinDoc12> findBydiligenceId(int dilId);
}

