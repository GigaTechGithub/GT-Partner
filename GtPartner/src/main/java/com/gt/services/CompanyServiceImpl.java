package com.gt.services;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.models.Company;
import com.gt.repo.CompanyRepository;

@Service
@Resource(name="CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public String saveCompany(Company company) {
		try {
			companyRepository.save(company);
			String rowId = company.getId().toString();
			return rowId;
		}
		
		catch (Exception e) {
			return "Failed";
		}
	}
}
