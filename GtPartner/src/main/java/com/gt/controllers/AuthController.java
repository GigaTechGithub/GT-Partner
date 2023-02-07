package com.gt.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gt.models.Users;
import com.gt.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
    @GetMapping({"/", "/login"})
    public String loginPage(Model model) {
        return "login/loginPage";
    }
    
    @PostMapping({"/login"})
    public String getLoginUser(Model m, @ModelAttribute("UserLogin") Users request, RedirectAttributes redirectAttributes) {
    	
    	HttpServletRequest servRequest = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = servRequest.getSession(true);

    	Users users = userService.findByusername(request.getUsername().toString());
    	if(users !=null) {
    		session.setAttribute("id", users.getId()); 
    		session.setAttribute("name", users.getName()); 
    		session.setAttribute("username", users.getUsername()); 
    		session.setAttribute("email", users.getEmail()); 
    		session.setAttribute("mobile", users.getMobile());
    		session.setAttribute("diligenceId", users.getDiligenceId());
    		
    		if (users.getPassword().equals(request.getPassword())) {
        		return "redirect:/home";
    		}else {
    			redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
    			return "redirect:/";
    		}
    	}else {
			redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
			return "redirect:/";
		}
    	
    }
    
    @GetMapping("/index")
    String getIndex(Model model) {
        return "html/index";
    }
    
}
