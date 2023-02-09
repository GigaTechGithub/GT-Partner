package com.gt.services;

import java.util.List;

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

	@Override
	public List<Company> findBydiligenceId(int dilId) {
		List<Company> comList = companyRepository.findBydiligenceId(dilId);
		
		if(comList.isEmpty()) {
			Company company = new Company();
			
			company.setId(null);
			company.setAddress(null);
			company.setCompanyName(null);
			company.setCompanySecondName(null);
			company.setCountry(null);			
			company.setCreatedBy(null);
			company.setDiligenceId(null);
			company.setEthical1(null);
			company.setEthical2(null);
			company.setExport1(null);
			company.setExport2(null);
			company.setIncorporation_date(null);
			company.setIsGov(null);
			company.setIsGovCon(null);
			company.setNoOfBod(null);
			company.setNoOfEmployees(null);
			company.setParentCompanyGlobalLocation(null);
			company.setParentCompanyGlobalName(null);
			company.setParentCompanyLocation(null);
			company.setParentCompanyName(null);
			company.setParentCompanySecondGlobalName(null);
			company.setParentCompanySecondName(null);
			company.setPersonalConnection(null);
			company.setProvince(null);
			company.setSecondAddress(null);
			company.setTaxId(null);
			company.setTelephone(null);
			company.setWebsite(null);
			
			comList.add(company);
		}
		return comList;
	}
	
	
}
