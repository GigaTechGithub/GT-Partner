package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc9;

public interface FinDoc9Repository extends JpaRepository<FinDoc9, Long>{
	List<FinDoc9> findBydiligenceId(int dilId);
}
