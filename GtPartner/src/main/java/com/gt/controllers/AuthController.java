package com.gt.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.gt.config.KaptchaConfig;
import com.gt.models.Users;
import com.gt.security.SecurityService;
import com.gt.services.KaptchaService;
import com.gt.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	KaptchaService kaptchaService;
	
	@Autowired
	private SecurityService securityService;	
    
	@GetMapping({"/", "/login"})
    public String loginPage(Model model) {
    	
    	if(securityService.isAuthenticated()) {
    	    return "redirect:/getLogin";
    	}
    	
        return "login/loginPage";
    }
	
    @GetMapping({"/getLogin"})
    public String getLoginUser(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
    	
    	Users user = null;
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(securityService.isAuthenticated() && authentication.getName() != null) {
			user = userService.findByusername(authentication.getName().toString());
		}
		
    	if(user !=null && user.getStatus() == 1) {       		
			session.setAttribute("id", user.getId()); 
    		session.setAttribute("name", user.getName()); 
    		session.setAttribute("username", user.getUsername()); 
    		session.setAttribute("email", user.getEmail()); 
    		session.setAttribute("mobile", user.getMobile());
    		session.setAttribute("diligenceId", user.getDiligenceId());
    		session.setAttribute("isAdmin", user.getIsAdmin());
    		
    		redirectAttributes.addFlashAttribute("user", user);
    	    return "redirect:/home";
    		
    	}else {
			redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
			return "redirect:/";
		}
    	
    }
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
    
    @PostMapping("/checkCaptcha")
    public ResponseEntity<Integer> checkCaptcha(@RequestParam("captchaCode") String captchaCode, HttpServletRequest req) {
    	if (!kaptchaService.validateCaptchaCode(req, captchaCode)) {			
			return ResponseEntity.ok(400);
	    }
		
		else {
			return ResponseEntity.ok(200);
		}
        
    }
    
}
