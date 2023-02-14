package com.gt.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gt.models.Bod;
import com.gt.models.Company;
import com.gt.models.Contracts;
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

@Controller
public class HomeController {	
	@Autowired
	DiligenceService diligenceService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	LegalService legalService;
	
	@Autowired
	RevenueService revenueService;
	
	@Autowired
	TechnologyService technologyService;
	
	@Autowired
	IpService ipService;
	
	@Autowired
	ItService itService;
	
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	BodService bodService;
	
	@Autowired
	ContractsService contractsService;
	
	@Autowired
	IncorporationDocService incorporationDocService;
	
	@Autowired
	IpDoc1Service ipDoc1Service;
	
	@Autowired
	IpDoc2Service ipDoc2Service;
	
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
	
	public Map<String, String> getCountries(){
		String[] countryCodes = Locale.getISOCountries();
		 
        Map<String, String> mapCountries = new TreeMap<>();
 
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();
            mapCountries.put(code, name);
        }
        
        return mapCountries;
	}
	
	@GetMapping({"/home"})
    public String getHomePage(Model model) {

		Company company = companyService.findBydiligenceId(diligenceId()).get(0);
		Legal legal = legalService.findBydiligenceId(diligenceId()).get(0);
		Revenue revenue = revenueService.findBydiligenceId(diligenceId()).get(0);
		Technology technology = technologyService.findBydiligenceId(diligenceId()).get(0);
		Ip ip = ipService.findBydiligenceId(diligenceId()).get(0);
		It it = itService.findBydiligenceId(diligenceId()).get(0);
		
		List<Owner> ownerList = ownerService.findBydiligenceId(diligenceId());
		List<Bod> bodList = bodService.findBydiligenceId(diligenceId());
		
		List<Contracts> contractsList = contractsService.findBydiligenceId(diligenceId());
		List<IncorporationDoc> incorporationDocList = incorporationDocService.findBydiligenceId(diligenceId());
		List<IpDoc1> ipDoc1List = ipDoc1Service.findBydiligenceId(diligenceId());
		List<IpDoc2> ipDoc2List = ipDoc2Service.findBydiligenceId(diligenceId());
		
		List<FinDoc1> finDoc1List = finDoc1Service.findBydiligenceId(diligenceId());
		List<FinDoc2> finDoc2List = finDoc2Service.findBydiligenceId(diligenceId());
		List<FinDoc3> finDoc3List = finDoc3Service.findBydiligenceId(diligenceId());
		List<FinDoc4> finDoc4List = finDoc4Service.findBydiligenceId(diligenceId());
		List<FinDoc5> finDoc5List = finDoc5Service.findBydiligenceId(diligenceId());
		List<FinDoc6> finDoc6List = finDoc6Service.findBydiligenceId(diligenceId());
		List<FinDoc7> finDoc7List = finDoc7Service.findBydiligenceId(diligenceId());
		List<FinDoc8> finDoc8List = finDoc8Service.findBydiligenceId(diligenceId());
		List<FinDoc9> finDoc9List = finDoc9Service.findBydiligenceId(diligenceId());
		List<FinDoc10> finDoc10List = finDoc10Service.findBydiligenceId(diligenceId());
		List<FinDoc11> finDoc11List = finDoc11Service.findBydiligenceId(diligenceId());
		List<FinDoc12> finDoc12List = finDoc12Service.findBydiligenceId(diligenceId());
		List<FinDoc13> finDoc13List = finDoc13Service.findBydiligenceId(diligenceId());
		
		
		
		
		
		int diligenceStatus = diligenceService.findById(diligenceId()).get(0).getProfileStatus();
		
		model.addAttribute("company", company);
		model.addAttribute("legal", legal);
		model.addAttribute("revenue", revenue);
		model.addAttribute("technology", technology);
		model.addAttribute("ip", ip);
		model.addAttribute("it", it);
		model.addAttribute("ownerList", ownerList);
		model.addAttribute("bodList", bodList);
		model.addAttribute("contractsList", contractsList);
		model.addAttribute("incorporationDocList", incorporationDocList);
		model.addAttribute("ipDoc1List", ipDoc1List);
		model.addAttribute("ipDoc2List", ipDoc2List);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("diligenceStatus", diligenceStatus);
		
    	//return "view/profileCompleteForm";
		
		return "view/CompanyInfoForm";
    }
	
	
	
}
