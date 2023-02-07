package com.gt.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gt.models.AjaxResponse;
import com.gt.models.Bod;
import com.gt.models.Company;
import com.gt.models.Owner;
import com.gt.models.Users;
import com.gt.services.BodService;
import com.gt.services.CompanyService;
import com.gt.services.OwnerService;

@RestController
public class ProfileFormController {
	@Autowired
	BodService bodService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	OwnerService ownerService;
	
	@PostMapping({"/addOwner"})
    public ResponseEntity<?> addOwner(@RequestBody Owner request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Owner owner = new Owner();
	    	owner.setOwnerName(request.getOwnerName());
	    	owner.setOwnerSecondName(request.getOwnerSecondName());
	    	owner.setOwnerPercent(request.getOwnerPercent());
	    	owner.setCreatedBy("1");
	    	owner.setDiligenceId("1");
	    	
	    	String result = ownerService.saveOwner(owner);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteOwner"})
    public ResponseEntity<?> deleteOwner(@RequestBody Owner request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
	    	
	    	String result = ownerService.deleteOwner(request.getId());
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addBod"})
    public ResponseEntity<?> addBod(@RequestBody Bod request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Bod bod = new Bod();
			bod.setBodName(request.getBodName());
			bod.setBodSecondName(request.getBodSecondName());
			bod.setTile(request.getTile());
			bod.setCreatedBy("1");
			bod.setDiligenceId("1");
	    	
	    	String result = bodService.saveBod(bod);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteBod"})
    public ResponseEntity<?> deleteBod(@RequestBody Bod request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
	    	
	    	String result = bodService.deleteBod(request.getId());
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addCompany"})
    public ResponseEntity<?> addCompany(@RequestBody Company request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Company company = new Company();
			
			company.setId(request.getId());
			company.setAccountStatus(10);
			company.setAddress(request.getAddress());
			company.setCompanyName(request.getCompanyName());
			company.setCompanySecondName(request.getCompanySecondName());
			company.setCountry(request.getCountry());			
			company.setCreatedBy(1);
			company.setDiligenceId(1);
			company.setEthical1(request.getEthical1());
			company.setEthical2(request.getEthical2());
			company.setExport1(request.getExport1());
			company.setExport2(request.getExport2());
			company.setIncorporation_date(request.getIncorporation_date());
			company.setIsGov(request.getIsGov());
			company.setIsGovCon(request.getIsGovCon());
			company.setNoOfBod(request.getNoOfBod());
			company.setNoOfEmployees(request.getNoOfEmployees());
			company.setParentCompanyGlobalLocation(request.getParentCompanyGlobalLocation());
			company.setParentCompanyGlobalName(request.getParentCompanyGlobalName());
			company.setParentCompanyLocation(request.getParentCompanyLocation());
			company.setParentCompanyName(request.getParentCompanyName());
			company.setParentCompanySecondGlobalName(request.getParentCompanySecondGlobalName());
			company.setParentCompanySecondName(request.getParentCompanySecondName());
			company.setPersonalConnection(request.getPersonalConnection());
			company.setProvince(request.getProvince());
			company.setSecondAddress(request.getSecondAddress());
			company.setTaxId(request.getTaxId());
			company.setTelephone(request.getTelephone());
			company.setWebsite(request.getWebsite());
	    	
	    	String result = companyService.saveCompany(company);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
}
