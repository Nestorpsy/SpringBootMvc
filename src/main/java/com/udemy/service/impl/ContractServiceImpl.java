package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepo;
import com.udemy.service.ContactService;

@Service("contactService")
public class ContractServiceImpl implements ContactService{
	
	@Autowired
	@Qualifier("contactRepo")
	private ContactRepo contactRepo;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepo.save(ContactConverter.modelToEntity(contactModel));		
		return ContactConverter.entityToModel(contactRepo.save(contact));
	}

	@Override
	public List<ContactModel> allContacts() {
		List<ContactModel> models = new ArrayList<>();
		List<Contact> contacts = contactRepo.findAll();
		for(Contact contact:contacts)
			models.add(ContactConverter.entityToModel(contactRepo.save(contact)));
		return models;
	}

	@Override
	public int deletContact(int id) {
		contactRepo.deleteById(id);
		return 1;
	}

	@Override
	public ContactModel findContact(int id) {
		Contact contact = contactRepo.findById(id);
		return ContactConverter.entityToModel(contactRepo.save(contact));
	}

}
