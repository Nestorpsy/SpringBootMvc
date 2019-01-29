package com.udemy.model;

public class CourseModel {
	private String name;
	private String description;
	private double price;
	private int hours;
	
	public CourseModel() {
		super();
	}
	
	public CourseModel(String name, String description, double price, int hours) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CourseModel [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", hours=");
		builder.append(hours);
		builder.append("]");
		return builder.toString();
	}	
}
