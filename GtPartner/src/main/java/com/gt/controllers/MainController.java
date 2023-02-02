package com.gt.controllers;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gt.models.Users;
import com.gt.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
    @GetMapping({"/"})
    public String loginPage(Model model) {
        return "login/loginPage";
    }
    
    @PostMapping({"/login"})
    public String userListView(Model m, @ModelAttribute("UserLogin") Users request) {
    	List<Users> users = userService.usersList();
    	if (users.get(0).getUsername().equals(request.getUsername()) && users.get(0).getPassword().equals(request.getPassword())) {
    		return "pages/home";
		}else {
			return "redirect:/";
		}
    }
    
}
