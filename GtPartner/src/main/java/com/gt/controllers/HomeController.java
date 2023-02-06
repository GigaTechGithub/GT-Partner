package com.gt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gt.models.Users;

@Controller
public class HomeController {
	
	@GetMapping({"/home"})
    public String getHomePage(Model m, @ModelAttribute("UserLogin") Users request) {
    	return "view/home";
    }
	
}
