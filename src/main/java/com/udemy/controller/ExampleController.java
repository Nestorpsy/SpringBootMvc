package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {	
	private static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@GetMapping(value="/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("people",exampleService.getListPeople());
		exampleComponent.sayTest();
		return EXAMPLE_VIEW;
	}
	
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
		modelAndView.addObject("person",new Person("Ness",27));
		return modelAndView;
	}
}
