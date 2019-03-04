package com.udemy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private static final String REDIRECT_CONTACT_LIST = "redirect:/contact/list";

	private final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactService")
	private ContactService contactService;
	
	@GetMapping("/contactform")
	public String contactForm(Model model,
			@RequestParam(name="id" , defaultValue="0") int id) {
		ContactModel contactModel = new ContactModel();
		if(id != 0)
			contactModel = contactService.findContact(id);
		model.addAttribute("contactModel", contactModel);
		LOG.info("Form id: "+id+" "+contactModel);
		return "contactform";
	}
	
	@GetMapping("/list")
	public String contacts(Model model){
		List<ContactModel> models = contactService.allContacts();
		model.addAttribute("contactlist",models);
		return "contacts";
	}
	
	@PostMapping("/addcontact")
	public String addContact(Model model,
			@ModelAttribute(name="contactModel") ContactModel contactModel) {		
		ContactModel contactModelReturn = contactService.addContact(contactModel);
		LOG.info(contactModel);
		if(contactModelReturn != null)
			model.addAttribute("resul",1);
		else
			model.addAttribute("resul",0);
		LOG.info(contactModelReturn);
		return REDIRECT_CONTACT_LIST;
	}	
	
	@GetMapping("/deletecontact")
	public String deletContact(Model model,
			@RequestParam(name="id" ,required=true) int id) {
		int result = contactService.deletContact(id);
		model.addAttribute("contactdelete",result);
		return REDIRECT_CONTACT_LIST;
	}
}
