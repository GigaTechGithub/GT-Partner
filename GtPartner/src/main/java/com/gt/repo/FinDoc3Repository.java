package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc3;

public interface FinDoc3Repository extends JpaRepository<FinDoc3, Long>{
	List<FinDoc3> findBydiligenceId(int dilId);
}
