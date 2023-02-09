package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long>{
	List<Revenue> findBydiligenceId(int dilId);
}
