package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.IncorporationDoc;

public interface IncorporationDocRepository extends JpaRepository<IncorporationDoc, Long>{
	List<IncorporationDoc> findBydiligenceId(int dilId);
}
