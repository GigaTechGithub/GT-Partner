package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{
	List<Owner> findBydiligenceId(int dilId);
}
