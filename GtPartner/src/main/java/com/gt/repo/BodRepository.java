package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Bod;

public interface BodRepository extends JpaRepository<Bod, Long>{
	List<Bod> findBydiligenceId(int dilId);
}
