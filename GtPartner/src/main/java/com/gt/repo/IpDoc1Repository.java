package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.IpDoc1;

public interface IpDoc1Repository extends JpaRepository<IpDoc1, Long>{
	List<IpDoc1> findBydiligenceId(int dilId);
}
