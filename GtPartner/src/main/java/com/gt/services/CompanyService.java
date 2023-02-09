package com.gt.services;

import java.util.List;

import com.gt.models.Company;

public interface CompanyService {
	String saveCompany(Company company);
	List<Company> findBydiligenceId(int dilId);
}
