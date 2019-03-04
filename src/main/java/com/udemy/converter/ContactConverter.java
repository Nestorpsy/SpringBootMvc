package com.udemy.converter;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public class ContactConverter {
	public static final Contact modelToEntity(ContactModel contactModel) {
		return new Contact(
				contactModel.getId(),
				contactModel.getFirstName(), 
				contactModel.getLastName(), 
				contactModel.getCity(), 
				contactModel.getTelephone());
	}

	public static final ContactModel entityToModel(Contact contact) {		
		return new ContactModel(
				contact.getId(), 
				contact.getFirstName(), 
				contact.getLastName(), 
				contact.getCity(), 
				contact.getTelephone());
	}
}
