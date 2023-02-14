package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.FinDoc8;

public interface FinDoc8Repository extends JpaRepository<FinDoc8, Long>{
	List<FinDoc8> findBydiligenceId(int dilId);
}
