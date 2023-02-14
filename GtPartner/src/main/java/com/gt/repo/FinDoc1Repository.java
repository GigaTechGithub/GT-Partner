package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc1;

public interface FinDoc1Repository extends JpaRepository<FinDoc1, Long>{
	List<FinDoc1> findBydiligenceId(int dilId);
}
