package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.It;

public interface ItRepository extends JpaRepository<It, Long>{
	List<It> findBydiligenceId(int dilId);
}
 