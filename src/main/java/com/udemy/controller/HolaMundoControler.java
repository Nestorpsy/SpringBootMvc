package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HolaMundoControler {
	
	@GetMapping("/holamundo")
	public String HolaMundo() {
		return "holamundo";
	}
}
