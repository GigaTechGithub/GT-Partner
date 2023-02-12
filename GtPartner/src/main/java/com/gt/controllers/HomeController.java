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

@Controller
public class HomeController {	
	
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
		
    	//return "view/profileCompleteForm";
		
		return "view/CompanyInfoForm";
    }
	
	
	
}
