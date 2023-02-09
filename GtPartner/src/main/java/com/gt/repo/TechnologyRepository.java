package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long>{
	List<Technology> findBydiligenceId(int dilId);
}
