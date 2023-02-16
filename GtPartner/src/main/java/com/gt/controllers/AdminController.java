package com.gt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gt.models.Diligence;
import com.gt.services.DiligenceService;

@Controller
public class AdminController {
	@Autowired
	DiligenceService diligenceService;
	
	@GetMapping("/admin")
    public String home() {
        return "admin-view/home/admin-home";
    }
	
	@GetMapping("/partners")
    public String partnerList(Model model) {
		List<Diligence> diligenceList = diligenceService.findBystatus(1);
		
		model.addAttribute("diligenceList", diligenceList);
		
        return "admin-view/partners/partnerList";
    }
	
	
	@GetMapping("/partnerCreate")
    public String partnerCreate() {
        return "admin-view/partner/partner-create";
    }
    
	
	
	
	
}
