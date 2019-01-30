package com.udemy.model;

public class ContactModel {
	private int id;
	private String firstName;
	private String lastName;
	private String city;
	private String telephone;
	
	public ContactModel() {
		super();
	}	
	public ContactModel(String firstName, String lastName, String city, String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.telephone = telephone;
	}
	public ContactModel(int id, String firstName, String lastName, String city, String telephone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append("]");
		return builder.toString();
	}	
}
