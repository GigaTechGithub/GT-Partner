package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Ip;

public interface IpRepository extends JpaRepository<Ip, Long>{
	List<Ip> findBydiligenceId(int dilId);
}
