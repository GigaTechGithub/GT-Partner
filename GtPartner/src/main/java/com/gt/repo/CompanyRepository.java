package com.gt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
