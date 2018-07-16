package com.johnwstump.webcustomertracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "access-denied";
	}
}
