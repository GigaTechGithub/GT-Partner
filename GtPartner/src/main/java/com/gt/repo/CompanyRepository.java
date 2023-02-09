package com.gt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	List<Company> findBydiligenceId(int dilId);

}
