package com.gt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gt.models.AjaxResponse;
import com.gt.models.Diligence;
import com.gt.models.Owner;
import com.gt.services.DiligenceService;

@Controller
public class AdminController {
	@Autowired
	DiligenceService diligenceService;
	
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
	
	@GetMapping("/admin")
    public String home() {
        return "admin-view/home/admin-home";
    }
	
	@GetMapping("/activePartnersList")
    public String partnerList(Model model) {
		List<Diligence> diligenceList = diligenceService.findBystatus(1);
		
		model.addAttribute("diligenceList", diligenceList);
		
        return "admin-view/partners/partnerList";
    }
	
	
	@GetMapping("/partnerCreate")
    public String partnerCreate(Model model) {
		List<Diligence> diligenceList = diligenceService.findAll();
		
		model.addAttribute("partners", diligenceList);
        return "admin-view/partners/createPartner";
    }
    
	
	@PostMapping({"/createDiligence"})
    public ResponseEntity<?> addDiligence(@RequestBody Diligence request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			Diligence diligence = new Diligence();
			diligence.setName(request.getName());
			diligence.setEmail(request.getEmail());
			diligence.setMobile(request.getMobile());
			diligence.setWebsite(request.getWebsite());
			diligence.setAddress(request.getAddress());
			diligence.setStatus(request.getStatus());
			diligence.setCreatedBy(createdById());
	    	
	    	String result = diligenceService.saveDiligence(diligence);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deletePartner"})
    public ResponseEntity<?> deletePartner(@RequestBody Diligence request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			
	    	String result = diligenceService.deleteDiligence(request.getId());
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
}
