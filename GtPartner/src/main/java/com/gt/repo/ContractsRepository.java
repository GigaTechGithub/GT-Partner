package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Contracts;

public interface ContractsRepository extends JpaRepository<Contracts, Long>{
	List<Contracts> findBydiligenceId(int dilId);
}

