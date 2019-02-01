package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.model.ContactModel;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/contactform")
	public String addCOntact(Model model) {
		model.addAttribute("contactModel", new ContactModel());
		return "contactform";
	}
	
	@GetMapping("/list")
	public String contacts(){
		return "contacts";
	}
	
	@PostMapping("/addcontact")
	public String addContact(Model model,
			@ModelAttribute(name="contactModel") ContactModel contactModel) {
		model.addAttribute("resultadd",1);
		LOG.info(contactModel);
		return "redirect:/contact/list";
	}
}
