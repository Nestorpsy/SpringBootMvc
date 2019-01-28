package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class ExampleControlTwo {

	private static final String EXAMPLE_VIEW = "example2";

	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", defaultValue = "S/I") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}

	@GetMapping("/request2/{mn}")
	public ModelAndView request2(@PathVariable("mn")String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		return mav;
	}

}
