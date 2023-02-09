package com.gt.controllers;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gt.models.Company;
import com.gt.models.Ip;
import com.gt.models.It;
import com.gt.models.Legal;
import com.gt.models.Revenue;
import com.gt.models.Technology;
import com.gt.models.Users;
import com.gt.services.CompanyService;
import com.gt.services.ContractsService;
import com.gt.services.IncorporationDocService;
import com.gt.services.IpDoc1Service;
import com.gt.services.IpDoc2Service;
import com.gt.services.IpService;
import com.gt.services.ItService;
import com.gt.services.LegalService;
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
	
	@GetMapping({"/home"})
    public String getHomePage(Model model) {

		Company company = companyService.findBydiligenceId(diligenceId()).get(0);
		Legal legal = legalService.findBydiligenceId(diligenceId()).get(0);
		Revenue revenue = revenueService.findBydiligenceId(diligenceId()).get(0);
		Technology technology = technologyService.findBydiligenceId(diligenceId()).get(0);
		Ip ip = ipService.findBydiligenceId(diligenceId()).get(0);
		It it = itService.findBydiligenceId(diligenceId()).get(0);
		
		model.addAttribute("company", company);
		model.addAttribute("legal", legal);
		model.addAttribute("revenue", revenue);
		model.addAttribute("technology", technology);
		model.addAttribute("ip", ip);
		model.addAttribute("it", it);
		
    	return "view/profileCompleteForm";
    }
	
	
	
}
