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
import org.springframework.web.servlet.view.RedirectView;

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

    	Users user = userService.findByusername(request.getUsername().toString());
    	if(user !=null) {
    		if(user.getStatus() == 1) {       		
        		if (user.getPassword().equals(request.getPassword())) {
        			session.setAttribute("id", user.getId()); 
            		session.setAttribute("name", user.getName()); 
            		session.setAttribute("username", user.getUsername()); 
            		session.setAttribute("email", user.getEmail()); 
            		session.setAttribute("mobile", user.getMobile());
            		session.setAttribute("diligenceId", user.getDiligenceId());
            		session.setAttribute("isAdmin", user.getIsAdmin());
            		
            		return "redirect:/home";
        		}else {
        			redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
        			return "redirect:/";
        		}
    		}
    		
    		else {
    			redirectAttributes.addFlashAttribute("message", "Invalid Username or Password");
    			return "redirect:/";
    		}
    		
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
        return "redirect:/login";
    }
    
    
    
    
    
    
}
