package com.gt.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.gt.models.AjaxResponse;
import com.gt.models.Bod;
import com.gt.models.Company;
import com.gt.models.Contracts;
import com.gt.models.Diligence;
import com.gt.models.FinDoc1;
import com.gt.models.FinDoc10;
import com.gt.models.FinDoc11;
import com.gt.models.FinDoc12;
import com.gt.models.FinDoc13;
import com.gt.models.FinDoc2;
import com.gt.models.FinDoc3;
import com.gt.models.FinDoc4;
import com.gt.models.FinDoc5;
import com.gt.models.FinDoc6;
import com.gt.models.FinDoc7;
import com.gt.models.FinDoc8;
import com.gt.models.FinDoc9;
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
import com.gt.services.DiligenceService;
import com.gt.services.FinDoc10Service;
import com.gt.services.FinDoc11Service;
import com.gt.services.FinDoc12Service;
import com.gt.services.FinDoc13Service;
import com.gt.services.FinDoc1Service;
import com.gt.services.FinDoc2Service;
import com.gt.services.FinDoc3Service;
import com.gt.services.FinDoc4Service;
import com.gt.services.FinDoc5Service;
import com.gt.services.FinDoc6Service;
import com.gt.services.FinDoc7Service;
import com.gt.services.FinDoc8Service;
import com.gt.services.FinDoc9Service;
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
	DiligenceService diligenceService;
	
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
	
	@Autowired
	FinDoc1Service finDoc1Service;
	
	@Autowired
	FinDoc2Service finDoc2Service;
	
	@Autowired
	FinDoc3Service finDoc3Service;
	
	@Autowired
	FinDoc4Service finDoc4Service;
	
	@Autowired
	FinDoc5Service finDoc5Service;
	
	@Autowired
	FinDoc6Service finDoc6Service;
	
	@Autowired
	FinDoc7Service finDoc7Service;
	
	@Autowired
	FinDoc8Service finDoc8Service;
	
	@Autowired
	FinDoc9Service finDoc9Service;
	
	@Autowired
	FinDoc10Service finDoc10Service;
	
	@Autowired
	FinDoc11Service finDoc11Service;
	
	@Autowired
	FinDoc12Service finDoc12Service;
	
	@Autowired
	FinDoc13Service finDoc13Service;
	
	
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
	    	owner.setIsSecondName(request.getIsSecondName());
	    	
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
			bod.setIsSecondName(request.getIsSecondName());
	    	
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
			company.setIsCompanySecondName(request.getIsCompanySecondName());
			company.setIsSecondAddress(request.getIsSecondAddress());
			company.setIsParentCopanySecondName(request.getIsParentCopanySecondName());
			company.setIsParentCompanySecondGlobalName(request.getIsParentCompanySecondGlobalName());
	    	
	    	String result = companyService.saveCompany(company);
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() < 10) {
	    		diligence.setProfileStatus(10);
		    	
		    	diligenceService.saveDiligence(diligence);
	    	}
	    	
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
			
			legal.setId(request.getId());
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
			legal.setLegal11(request.getLegal11());
			legal.setLegal12(request.getLegal12());
			legal.setLegal13(request.getLegal13());
			legal.setLegal14(request.getLegal14());
			legal.setLegal15(request.getLegal15());
			legal.setLegal16(request.getLegal16());
			
	    	String result = legalService.saveLegal(legal);
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() < 20) {
	    		diligence.setProfileStatus(20);
		    	
		    	diligenceService.saveDiligence(diligence);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addFinancial"})
    public ResponseEntity<?> addFinancial() {
		AjaxResponse response = new AjaxResponse();
		String result="Success";
		try {
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() < 30) {
	    		diligence.setProfileStatus(30);
		    	
		    	result = diligenceService.saveDiligence(diligence);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@RequestMapping(value = "/addContracts", method = RequestMethod.POST)
    public ResponseEntity<?> addContracts(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		
		try {
			
			Contracts contracts = new Contracts();
			
			contracts.setCreatedBy(createdById());
			contracts.setDiligenceId(diligenceId());
			contracts.setFileName(fileName);
			contracts.setFilePath(filePath);
			contracts.setFileType(docType);
			
	    	String result = contractsService.saveContacts(contracts);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	contracts.setId(Long.parseLong(result));;
	    	contracts.setFilePath(filePath);
	    	
	    	contractsService.saveContacts(contracts);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteContracts"})
    public ResponseEntity<?> deleteContracts(@RequestBody Contracts request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Contracts contracts = contractsService.findById(request.getId());
	    	
	    	String result = contractsService.deleteContracts(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(contracts.getFilePath());
		        Files.delete(path);
	    	}	    	
	    	
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
			
			revenue.setId(request.getId());
			revenue.setCreatedBy(createdById());
			revenue.setDiligenceId(diligenceId());
			revenue.setRevenue1(request.getRevenue1());
			revenue.setRevenue2(request.getRevenue2());
			revenue.setRevenue3(request.getRevenue3());
			revenue.setRevenue4(request.getRevenue4());
			
	    	String result = revenueService.saveRevenue(revenue);
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() < 40) {
	    		
	    		diligence.setProfileStatus(40);
		    	
		    	diligenceService.saveDiligence(diligence);
	    	}
	    	
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
			
			technology.setId(request.getId());
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
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() < 50) {
	    		
	    		diligence.setProfileStatus(50);
		    	
		    	diligenceService.saveDiligence(diligence);
	    	}			
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIncorporationDoc"})
    public ResponseEntity<?> addIncorporationDoc(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			IncorporationDoc incorporationDoc = new IncorporationDoc();
			
			incorporationDoc.setCreatedBy(createdById());
			incorporationDoc.setDiligenceId(diligenceId());
			incorporationDoc.setFileName(fileName);
			incorporationDoc.setFilePath(filePath);
			incorporationDoc.setFileType(docType);
			
	    	String result = incorporationDocService.saveIncorporationDoc(incorporationDoc);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	incorporationDoc.setId(Long.parseLong(result));;
	    	incorporationDoc.setFilePath(filePath);
	    	
	    	incorporationDocService.saveIncorporationDoc(incorporationDoc);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/deleteIncorporationDoc"})
    public ResponseEntity<?> deleteIncorporationDoc(@RequestBody IncorporationDoc request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IncorporationDoc incorporationDoc = incorporationDocService.findById(request.getId());
	    	
	    	String result = incorporationDocService.deleteIncorporationDoc(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(incorporationDoc.getFilePath());
		        Files.delete(path);
	    	}
	    	
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
			
			ip.setId(request.getId());
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
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);
	    	
	    	if(diligence.getProfileStatus() <60) {
	    		
	    		diligence.setProfileStatus(60);
		    	
		    	diligenceService.saveDiligence(diligence);
	    	}			
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	
	@PostMapping({"/addIpDoc1"})
    public ResponseEntity<?> addIpDoc1(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			IpDoc1 ipDoc1 = new IpDoc1();
			
			ipDoc1.setCreatedBy(createdById());
			ipDoc1.setDiligenceId(diligenceId());
			ipDoc1.setFileName(fileName);
			ipDoc1.setFilePath(filePath);
			ipDoc1.setFileType(docType);
			
	    	String result = ipDoc1Service.saveIpDoc1(ipDoc1);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	ipDoc1.setId(Long.parseLong(result));;
	    	ipDoc1.setFilePath(filePath);
	    	
	    	ipDoc1Service.saveIpDoc1(ipDoc1);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteIpDoc1"})
    public ResponseEntity<?> deleteIpDoc1(@RequestBody IncorporationDoc request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IpDoc1 ipDoc1 = ipDoc1Service.findById(request.getId());
			
	    	String result = ipDoc1Service.deleteIpDoc1(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(ipDoc1.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addIpDoc2"})
    public ResponseEntity<?> addIpDoc2(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		
		try {
			
			IpDoc2 ipDoc2 = new IpDoc2();
			
			ipDoc2.setCreatedBy(createdById());
			ipDoc2.setDiligenceId(diligenceId());
			ipDoc2.setFileName(fileName);
			ipDoc2.setFilePath(filePath);
			ipDoc2.setFileType(docType);
			
	    	String result = ipDoc2Service.saveIpDoc2(ipDoc2);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	ipDoc2.setId(Long.parseLong(result));;
	    	ipDoc2.setFilePath(filePath);
	    	
	    	ipDoc2Service.saveIpDoc2(ipDoc2);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteIpDoc2"})
    public ResponseEntity<?> deleteIpDoc2(@RequestBody IncorporationDoc request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			IpDoc2 ipDoc2 = ipDoc2Service.findById(request.getId());
	    	String result = ipDoc2Service.deleteIpDoc2(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(ipDoc2.getFilePath());
		        Files.delete(path);
	    	}
	    	
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
			
			it.setId(request.getId());
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
			it.setIt10(request.getIt10());
			
	    	String result = itService.saveIt(it);
	    	
	    	Diligence diligence = diligenceService.findByid(diligenceId()).get(0);

			diligence.setProfileStatus(90);
	    	
	    	diligenceService.saveDiligence(diligence);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/addFinDoc1"})
    public ResponseEntity<?> addFinDoc1(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
						
			FinDoc1 finDoc1 = new FinDoc1();
			
			finDoc1.setCreatedBy(createdById());
			finDoc1.setDiligenceId(diligenceId());
			finDoc1.setFileName(fileName);
			finDoc1.setFilePath(filePath);
			finDoc1.setFileType(docType);
			
	    	String result = finDoc1Service.saveFinDoc1(finDoc1);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc1.setId(Long.parseLong(result));;
	    	finDoc1.setFilePath(filePath);
	    	
	    	finDoc1Service.saveFinDoc1(finDoc1);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc2"})
    public ResponseEntity<?> addFinDoc2(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc2 finDoc2 = new FinDoc2();
			
			finDoc2.setCreatedBy(createdById());
			finDoc2.setDiligenceId(diligenceId());
			finDoc2.setFileName(fileName);
			finDoc2.setFilePath(filePath);
			finDoc2.setFileType(docType);
			
	    	String result = finDoc2Service.saveFinDoc2(finDoc2);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc2.setId(Long.parseLong(result));;
	    	finDoc2.setFilePath(filePath);
	    	
	    	finDoc2Service.saveFinDoc2(finDoc2);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc3"})
    public ResponseEntity<?> addFinDoc3(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc3 finDoc3 = new FinDoc3();
			
			finDoc3.setCreatedBy(createdById());
			finDoc3.setDiligenceId(diligenceId());
			finDoc3.setFileName(fileName);
			finDoc3.setFilePath(filePath);
			finDoc3.setFileType(docType);
			
	    	String result = finDoc3Service.saveFinDoc3(finDoc3);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc3.setId(Long.parseLong(result));;
	    	finDoc3.setFilePath(filePath);
	    	
	    	finDoc3Service.saveFinDoc3(finDoc3);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc4"})
    public ResponseEntity<?> addFinDoc4(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc4 finDoc4 = new FinDoc4();
			
			finDoc4.setCreatedBy(createdById());
			finDoc4.setDiligenceId(diligenceId());
			finDoc4.setFileName(fileName);
			finDoc4.setFilePath(filePath);
			finDoc4.setFileType(docType);
			
	    	String result = finDoc4Service.saveFinDoc4(finDoc4);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc4.setId(Long.parseLong(result));;
	    	finDoc4.setFilePath(filePath);
	    	
	    	finDoc4Service.saveFinDoc4(finDoc4);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc5"})
    public ResponseEntity<?> addFinDoc5(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc5 finDoc5 = new FinDoc5();
			
			finDoc5.setCreatedBy(createdById());
			finDoc5.setDiligenceId(diligenceId());
			finDoc5.setFileName(fileName);
			finDoc5.setFilePath(filePath);
			finDoc5.setFileType(docType);
			
	    	String result = finDoc5Service.saveFinDoc5(finDoc5);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc5.setId(Long.parseLong(result));;
	    	finDoc5.setFilePath(filePath);
	    	
	    	finDoc5Service.saveFinDoc5(finDoc5);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc6"})
    public ResponseEntity<?> addFinDoc6(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc6 finDoc6 = new FinDoc6();
			
			finDoc6.setCreatedBy(createdById());
			finDoc6.setDiligenceId(diligenceId());
			finDoc6.setFileName(fileName);
			finDoc6.setFilePath(filePath);
			finDoc6.setFileType(docType);
			
	    	String result = finDoc6Service.saveFinDoc6(finDoc6);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc6.setId(Long.parseLong(result));;
	    	finDoc6.setFilePath(filePath);
	    	
	    	finDoc6Service.saveFinDoc6(finDoc6);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc7"})
    public ResponseEntity<?> addFinDoc7(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc7 finDoc7 = new FinDoc7();
			
			finDoc7.setCreatedBy(createdById());
			finDoc7.setDiligenceId(diligenceId());
			finDoc7.setFileName(fileName);
			finDoc7.setFilePath(filePath);
			finDoc7.setFileType(docType);
			
	    	String result = finDoc7Service.saveFinDoc7(finDoc7);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc7.setId(Long.parseLong(result));;
	    	finDoc7.setFilePath(filePath);
	    	
	    	finDoc7Service.saveFinDoc7(finDoc7);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc8"})
    public ResponseEntity<?> addFinDoc8(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc8 finDoc8 = new FinDoc8();
			
			finDoc8.setCreatedBy(createdById());
			finDoc8.setDiligenceId(diligenceId());
			finDoc8.setFileName(fileName);
			finDoc8.setFilePath(filePath);
			finDoc8.setFileType(docType);
			
	    	String result = finDoc8Service.saveFinDoc8(finDoc8);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc8.setId(Long.parseLong(result));;
	    	finDoc8.setFilePath(filePath);
	    	
	    	finDoc8Service.saveFinDoc8(finDoc8);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc9"})
    public ResponseEntity<?> addFinDoc9(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc9 finDoc9 = new FinDoc9();
			
			finDoc9.setCreatedBy(createdById());
			finDoc9.setDiligenceId(diligenceId());
			finDoc9.setFileName(fileName);
			finDoc9.setFilePath(filePath);
			finDoc9.setFileType(docType);
			
	    	String result = finDoc9Service.saveFinDoc9(finDoc9);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc9.setId(Long.parseLong(result));;
	    	finDoc9.setFilePath(filePath);
	    	
	    	finDoc9Service.saveFinDoc9(finDoc9);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc10"})
    public ResponseEntity<?> addFinDoc10(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc10 finDoc10 = new FinDoc10();
			
			finDoc10.setCreatedBy(createdById());
			finDoc10.setDiligenceId(diligenceId());
			finDoc10.setFileName(fileName);
			finDoc10.setFilePath(filePath);
			finDoc10.setFileType(docType);
			
	    	String result = finDoc10Service.saveFinDoc10(finDoc10);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc10.setId(Long.parseLong(result));;
	    	finDoc10.setFilePath(filePath);
	    	
	    	finDoc10Service.saveFinDoc10(finDoc10);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc11"})
    public ResponseEntity<?> addFinDoc11(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc11 finDoc11 = new FinDoc11();
			
			finDoc11.setCreatedBy(createdById());
			finDoc11.setDiligenceId(diligenceId());
			finDoc11.setFileName(fileName);
			finDoc11.setFilePath(filePath);
			finDoc11.setFileType(docType);
			
	    	String result = finDoc11Service.saveFinDoc11(finDoc11);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc11.setId(Long.parseLong(result));;
	    	finDoc11.setFilePath(filePath);
	    	
	    	finDoc11Service.saveFinDoc11(finDoc11);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc12"})
    public ResponseEntity<?> addFinDoc12(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc12 finDoc12 = new FinDoc12();
			
			finDoc12.setCreatedBy(createdById());
			finDoc12.setDiligenceId(diligenceId());
			finDoc12.setFileName(fileName);
			finDoc12.setFilePath(filePath);
			finDoc12.setFileType(docType);
			
	    	String result = finDoc12Service.saveFinDoc12(finDoc12);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc12.setId(Long.parseLong(result));;
	    	finDoc12.setFilePath(filePath);
	    	
	    	finDoc12Service.saveFinDoc12(finDoc12);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/addFinDoc13"})
    public ResponseEntity<?> addFinDoc13(@RequestParam("selectFile") MultipartFile selectFile, @RequestParam("docType") String docType) {
		AjaxResponse response = new AjaxResponse();
		String fileName = selectFile.getOriginalFilename();
		String filePath = "C:\\upload\\"+ diligenceId()+"-"+fileName;
		try {
			
			FinDoc13 finDoc13 = new FinDoc13();
			
			finDoc13.setCreatedBy(createdById());
			finDoc13.setDiligenceId(diligenceId());
			finDoc13.setFileName(fileName);
			finDoc13.setFilePath(filePath);
			finDoc13.setFileType(docType);
			
	    	String result = finDoc13Service.saveFinDoc13(finDoc13);
	    	
	    	filePath = "C:\\upload\\"+ diligenceId()+"-"+result+"-"+fileName;
	    	
	    	finDoc13.setId(Long.parseLong(result));;
	    	finDoc13.setFilePath(filePath);
	    	
	    	finDoc13Service.saveFinDoc13(finDoc13);
	    	
	    	selectFile.transferTo( new File(filePath));
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
		
    }
	
	@PostMapping({"/deleteFinDoc1"})
    public ResponseEntity<?> deleteFinDoc1(@RequestBody FinDoc1 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			
			FinDoc1 finDoc1 = finDoc1Service.findById(request.getId());
	    	
	    	String result = finDoc1Service.deleteFinDoc1(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc1.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc2"})
    public ResponseEntity<?> deleteFinDoc2(@RequestBody FinDoc2 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc2 finDoc2 = finDoc2Service.findById(request.getId());
	    	String result = finDoc2Service.deleteFinDoc2(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc2.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc3"})
    public ResponseEntity<?> deleteFinDoc3(@RequestBody FinDoc3 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc3 finDoc3 = finDoc3Service.findById(request.getId());
	    	String result = finDoc3Service.deleteFinDoc3(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc3.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc4"})
    public ResponseEntity<?> deleteFinDoc4(@RequestBody FinDoc4 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc4 finDoc4 = finDoc4Service.findById(request.getId());
	    	String result = finDoc4Service.deleteFinDoc4(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc4.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc5"})
    public ResponseEntity<?> deleteFinDoc5(@RequestBody FinDoc5 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc5 finDoc5 = finDoc5Service.findById(request.getId());
	    	String result = finDoc5Service.deleteFinDoc5(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc5.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc6"})
    public ResponseEntity<?> deleteFinDoc6(@RequestBody FinDoc6 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc6 finDoc6 = finDoc6Service.findById(request.getId());
	    	String result = finDoc6Service.deleteFinDoc6(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc6.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	
	@PostMapping({"/deleteFinDoc7"})
    public ResponseEntity<?> deleteFinDoc7(@RequestBody FinDoc7 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc7 finDoc7 = finDoc7Service.findById(request.getId());
	    	String result = finDoc7Service.deleteFinDoc7(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc7.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc8"})
    public ResponseEntity<?> deleteFinDoc8(@RequestBody FinDoc8 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc8 finDoc8 = finDoc8Service.findById(request.getId());
	    	String result = finDoc8Service.deleteFinDoc8(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc8.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc9"})
    public ResponseEntity<?> deleteFinDoc9(@RequestBody FinDoc9 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc9 finDoc9 = finDoc9Service.findById(request.getId());
	    	String result = finDoc9Service.deleteFinDoc9(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc9.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc10"})
    public ResponseEntity<?> deleteFinDoc10(@RequestBody FinDoc10 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc10 finDoc10 = finDoc10Service.findById(request.getId());
	    	String result = finDoc10Service.deleteFinDoc10(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc10.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc11"})
    public ResponseEntity<?> deleteFinDoc11(@RequestBody FinDoc11 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc11 finDoc11 = finDoc11Service.findById(request.getId());
	    	String result = finDoc11Service.deleteFinDoc11(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc11.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc12"})
    public ResponseEntity<?> deleteFinDoc12(@RequestBody FinDoc12 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc12 finDoc12 = finDoc12Service.findById(request.getId());
	    	String result = finDoc12Service.deleteFinDoc12(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc12.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deleteFinDoc13"})
    public ResponseEntity<?> deleteFinDoc13(@RequestBody FinDoc13 request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			FinDoc13 finDoc13 = finDoc13Service.findById(request.getId());
	    	String result = finDoc13Service.deleteFinDoc13(request.getId());
	    	
	    	if(result == "Success") {		        
		        Path path = Paths.get(finDoc13.getFilePath());
		        Files.delete(path);
	    	}
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@GetMapping("/viewUploadedFile")
	public ResponseEntity<Resource> viewFile(@RequestParam("row") Long row, @RequestParam("type") String type) throws IOException {
	    String filepath;
		if(type.contentEquals("fin1Table")) {
	    	filepath = finDoc1Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin2Table")) {
	    	filepath = finDoc2Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin3Table")) {
	    	filepath = finDoc3Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin4Table")) {
	    	filepath = finDoc4Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin5Table")) {
	    	filepath = finDoc5Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin6Table")) {
	    	filepath = finDoc6Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin7Table")) {
	    	filepath = finDoc7Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin8Table")) {
	    	filepath = finDoc8Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin9Table")) {
	    	filepath = finDoc9Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin10Table")) {
	    	filepath = finDoc10Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin11Table")) {
	    	filepath = finDoc11Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin12Table")) {
	    	filepath = finDoc12Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("fin13Table")) {
	    	filepath = finDoc13Service.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("revTable")) {
	    	filepath = contractsService.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("techTable")) {
	    	filepath = incorporationDocService.findById(row).getFilePath();
	    }
		
		else if(type.contentEquals("ipTable")) {
	    	filepath = ipDoc1Service.findById(row).getFilePath();
	    }
		
		else {
	    	filepath = ipDoc2Service.findById(row).getFilePath();
	    }
		
		
		// Read the file from the file system or database
	    Path filePath = Paths.get(filepath);
	    Resource resource = new UrlResource(filePath.toUri());

	    // Determine the file's content type based on its extension
	    String contentType;
	    String extension = FilenameUtils.getExtension(filepath).toLowerCase();
	    switch (extension) {
	        case "pdf":
	            contentType = MediaType.APPLICATION_PDF_VALUE;
	            break;
	        case "xls":
	        case "xlsx":
	            contentType = "application/vnd.ms-excel";
	            break;
	        case "doc":
	        case "docx":
	            contentType = "application/msword";
	            break;
	        case "png":
	            contentType = "image/png";
	            break;
	        case "jpg":
	        case "jpeg":
	            contentType = "image/jpeg";
	            break;
	        // Add more cases for additional file types as needed
	        default:
	            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
	            break;
	    }

	    // Set the response headers to display the file in a new tab
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType(contentType));
	    headers.setContentDisposition(ContentDisposition.inline().filename(filepath).build());

	    // Return the file contents as a response
	    return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
	
}
