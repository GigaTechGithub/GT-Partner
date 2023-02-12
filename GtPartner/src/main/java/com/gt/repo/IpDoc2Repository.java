package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.IpDoc2;

public interface IpDoc2Repository extends JpaRepository<IpDoc2, Long>{
	List<IpDoc2> findBydiligenceId(int dilId);
}
