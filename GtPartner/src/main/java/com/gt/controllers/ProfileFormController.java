package com.gt.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.gt.models.AjaxResponse;
import com.gt.models.Bod;
import com.gt.models.Company;
import com.gt.models.Contracts;
import com.gt.models.IncorporationDoc;
import com.gt.models.Ip;
import com.gt.models.IpDoc1;
import com.gt.models.IpDoc2;
import com.gt.models.It;
import com.gt.models.Legal;
import com.gt.models.Owner;
import com.gt.models.Revenue;
import com.gt.models.Technology;
import com.gt.services.BodService;
import com.gt.services.CompanyService;
import com.gt.services.ContractsService;
import com.gt.services.IncorporationDocService;
import com.gt.services.IpDoc1Service;
import com.gt.services.IpDoc2Service;
import com.gt.services.IpService;
import com.gt.services.ItService;
import com.gt.services.LegalService;
import com.gt.services.OwnerService;
import com.gt.services.RevenueService;
import com.gt.services.TechnologyService;

@RestController
public class ProfileFormController {
	
	@Autowired
	BodService bodService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	LegalService legalService;
	
	@Autowired
	ContractsService contractsService;
	
	@Autowired
	RevenueService revenueService;
	
	@Autowired
	TechnologyService technologyService;
	
	@Autowired
	IncorporationDocService incorporationDocService;
	
	@Autowired
	IpService ipService;
	
	@Autowired
	IpDoc1Service ipDoc1Service;
	
	@Autowired
	IpDoc2Service ipDoc2Service;
	
	@Autowired
	ItService itService;
	
	@Autowired
	OwnerService ownerService;
	
	public HttpSession getSession() {
		HttpServletRequest servRequest = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = servRequest.getSession(true);
		return session;
	}
	
	public Integer createdById () {
		return Integer.parseInt(getSession().getAttribute("id").toString());
	}
	
	public Integer diligenceId () {
		return Integer.parseInt(getSession().getAttribute("diligenceId").toString());
	}
	
	@PostMapping({"/addOwner"})
    public ResponseEntity<?> addOwner(@RequestBody Owner request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Owner owner = new Owner();
	    	owner.setOwnerName(request.getOwnerName());
	    	owner.setOwnerSecondName(request.getOwnerSecondName());
	    	owner.setOwnerPercent(request.getOwnerPercent());
	    	owner.setCreatedBy(createdById());
	    	owner.setDiligenceId(diligenceId());
	    	
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
			bod.setCreatedBy(createdById());
			bod.setDiligenceId(diligenceId());
	    	
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
			company.setCreatedBy(createdById());
			company.setDiligenceId(diligenceId());
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
	
	@PostMapping({"/addLegal"})
    public ResponseEntity<?> addLegal(@RequestBody Legal request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Legal legal = new Legal();
			
			legal.setCreatedBy(createdById());
			legal.setDiligenceId(diligenceId());
			legal.setLegal1(request.getLegal1());
			legal.setLegal2(request.getLegal2());
			legal.setLegal3(request.getLegal3());
			legal.setLegal4(request.getLegal4());
			legal.setLegal5(request.getLegal5());
			legal.setLegal6(request.getLegal6());
			legal.setLegal7(request.getLegal7());
			legal.setLegal8(request.getLegal8());
			legal.setLegal9(request.getLegal9());
			legal.setLegal10(request.getLegal10());
			
	    	String result = legalService.saveLegal(legal);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addContracts"})
    public ResponseEntity<?> addLegal(@RequestBody Contracts request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Contracts contracts = new Contracts();
			
			contracts.setCreatedBy(createdById());
			contracts.setDiligenceId(diligenceId());
			contracts.setFileName(request.getFileName());
			contracts.setFilePath(request.getFilePath());
			
	    	String result = contractsService.saveContacts(contracts);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addRevenue"})
    public ResponseEntity<?> addRevenue(@RequestBody Revenue request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Revenue revenue = new Revenue();
			
			revenue.setCreatedBy(createdById());
			revenue.setDiligenceId(diligenceId());
			revenue.setRevenue1(request.getRevenue1());
			revenue.setRevenue2(request.getRevenue2());
			revenue.setRevenue3(request.getRevenue3());
			revenue.setRevenue4(request.getRevenue4());
			
	    	String result = revenueService.saveRevenue(revenue);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addTechnology"})
    public ResponseEntity<?> addTechnology(@RequestBody Technology request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Technology technology = new Technology();
			
			technology.setCreatedBy(createdById());
			technology.setDiligenceId(diligenceId());
			technology.setTech1(request.getTech1());
			technology.setTech2(request.getTech2());
			technology.setTech3(request.getTech3());
			technology.setTech4(request.getTech4());
			technology.setTech5(request.getTech5());
			technology.setTech6(request.getTech6());
			technology.setTech7(request.getTech7());
			technology.setTech8(request.getTech8());
			technology.setTech9(request.getTech9());
			technology.setTech10(request.getTech10());
			technology.setTech11(request.getTech11());
			technology.setTech12(request.getTech12());
			technology.setTech13(request.getTech13());
			technology.setTech14(request.getTech14());
			technology.setTech15(request.getTech15());
			technology.setTech16(request.getTech16());
			technology.setTech17(request.getTech17());
			technology.setTech18(request.getTech18());
			technology.setTech19(request.getTech19());
			technology.setTech20(request.getTech20());
			technology.setTech21(request.getTech21());
			technology.setTech22(request.getTech22());
			technology.setTech23(request.getTech23());
			technology.setTech24(request.getTech24());
			technology.setTech25(request.getTech25());
			technology.setTech26(request.getTech26());
			technology.setTech27(request.getTech27());
			technology.setTech28(request.getTech28());
			technology.setTech29(request.getTech29());
			technology.setTech30(request.getTech30());
			technology.setTech31(request.getTech31());
			technology.setTech32(request.getTech32());
			technology.setTech33(request.getTech33());
			technology.setTech34(request.getTech34());
			technology.setTech35(request.getTech35());
			technology.setTech36(request.getTech36());
			technology.setTech37(request.getTech37());
			technology.setTech38(request.getTech38());
			technology.setTech39(request.getTech39());
			technology.setTech40(request.getTech40());
			technology.setTech41(request.getTech41());
			technology.setTech42(request.getTech42());
			
			
	    	String result = technologyService.saveTechnology(technology);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIncorporationDoc"})
    public ResponseEntity<?> addIncorporationDoc(@RequestBody IncorporationDoc request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IncorporationDoc incorporationDoc = new IncorporationDoc();
			
			incorporationDoc.setCreatedBy(createdById());
			incorporationDoc.setDiligenceId(diligenceId());
			incorporationDoc.setFileName(request.getFileName());
			incorporationDoc.setFilePath(request.getFilePath());
			
	    	String result = incorporationDocService.saveIncorporationDoc(incorporationDoc);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIp"})
    public ResponseEntity<?> addIp(@RequestBody Ip request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Ip ip = new Ip();
			
			ip.setCreatedBy(createdById());
			ip.setDiligenceId(diligenceId());
			ip.setIp1(request.getIp1());
			ip.setIp2(request.getIp2());
			ip.setIp3(request.getIp3());
			ip.setIp4(request.getIp4());
			ip.setIp5(request.getIp5());
			ip.setIp6(request.getIp6());
			ip.setIp7(request.getIp7());
			ip.setIp8(request.getIp8());
			ip.setIp9(request.getIp9());
			
	    	String result = ipService.saveIp(ip);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	
	@PostMapping({"/addIpDoc1"})
    public ResponseEntity<?> addIp(@RequestBody IpDoc1 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IpDoc1 ipDoc1 = new IpDoc1();
			
			ipDoc1.setCreatedBy(createdById());
			ipDoc1.setDiligenceId(diligenceId());
			ipDoc1.setFileName(request.getFileName());
			ipDoc1.setFilePath(request.getFilePath());
			ipDoc1.setFileType(request.getFileType());
			
	    	String result = ipDoc1Service.saveIpDoc1(ipDoc1);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIpDoc2"})
    public ResponseEntity<?> addIp(@RequestBody IpDoc2 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IpDoc2 ipDoc2 = new IpDoc2();
			
			ipDoc2.setCreatedBy(createdById());
			ipDoc2.setDiligenceId(diligenceId());
			ipDoc2.setFileName(request.getFileName());
			ipDoc2.setFilePath(request.getFilePath());
			ipDoc2.setFileType(request.getFileType());
			
	    	String result = ipDoc2Service.saveIpDoc2(ipDoc2);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIt"})
    public ResponseEntity<?> addIt(@RequestBody It request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			It it = new It();
			
			it.setCreatedBy(createdById());
			it.setDiligenceId(diligenceId());
			it.setIt1(request.getIt1());
			it.setIt2(request.getIt2());
			it.setIt3(request.getIt3());
			it.setIt4(request.getIt4());
			it.setIt5(request.getIt5());
			it.setIt6(request.getIt6());
			it.setIt7(request.getIt7());
			it.setIt8(request.getIt8());
			it.setIt9(request.getIt9());
			
	    	String result = itService.saveIt(it);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	
}
