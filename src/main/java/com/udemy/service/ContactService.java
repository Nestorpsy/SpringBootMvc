package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactModel;

public interface ContactService {
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract ContactModel findContact(int id);
	public abstract List<ContactModel> allContacts();
	public abstract int deletContact(int id);
}
