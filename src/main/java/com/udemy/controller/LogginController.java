package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.UserCredentials;

@Controller
public class LogginController {
	private static final Log LOG	= LogFactory.getLog(LogginController.class);

	@GetMapping("/")
	public String redirectLoging() {
		return "redirect:/login";
	}

	@GetMapping("/login")  
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {			
		model.addAttribute("error",error);
		model.addAttribute("logout",logout);
		model.addAttribute("userCredentials",new UserCredentials());
		return "login";
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredentials credentials) {
		LOG.info(credentials);
		if (credentials != null && 
				credentials.getUser().equals("user") &&
				credentials.getPassword().equals("user"))
			return "contacts";
		return "redirect:/login?error";
	}
}
