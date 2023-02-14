package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc5;

public interface FinDoc5Repository extends JpaRepository<FinDoc5, Long>{
	List<FinDoc5> findBydiligenceId(int dilId);
}
