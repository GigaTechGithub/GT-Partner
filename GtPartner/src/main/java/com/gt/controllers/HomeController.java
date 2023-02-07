package com.gt.controllers;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gt.models.Users;

@Controller
public class HomeController {
	
	
	
	@GetMapping({"/home"})
    public String getHomePage(Model m, @ModelAttribute("UserLogin") Users request) {
		
    	return "view/profileCompleteForm";
    }
	
}
