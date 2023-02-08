package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Diligence;

public interface DiligenceRepository extends JpaRepository<Diligence, Long>{
	List<Diligence> findById(long id);
}
