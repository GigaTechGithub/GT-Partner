package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc11;

public interface FinDoc11Repository extends JpaRepository<FinDoc11, Long>{
	List<FinDoc11> findBydiligenceId(int dilId);
}
