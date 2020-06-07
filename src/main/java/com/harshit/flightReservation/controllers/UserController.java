package com.harshit.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harshit.flightReservation.entities.User;
import com.harshit.flightReservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/RegisterUser";
	}
	
	@RequestMapping(value="/RegisterUser" , method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user)
	{
		userRepo.save(user);
		return "login/Login";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam("email")String email, @RequestParam("password")String password , ModelMap modelmap) {
		User user = userRepo.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}
		else {
			modelmap.addAttribute("msg" , "Invalid username or password");
			return"login/Login";
		}
	
	}
}
