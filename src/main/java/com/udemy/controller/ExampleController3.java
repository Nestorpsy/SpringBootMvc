package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class ExampleController3 {	
	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "resultAddPerson";
	private static final Log LOGGER = LogFactory.getLog(ExampleController3.class);
	
	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showForm";
//	}
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {		
		if(result.hasErrors())
			return new ModelAndView(FORM_VIEW); 
		LOGGER.info("ExampleController3.addPerson("+person+")");
		ModelAndView view = new ModelAndView(RESULT_VIEW);
		view.addObject("person",person);
		return view;
	}
}