package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Curso;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public final class CourseConverter {
	
	
	public CourseModel entityToModel(Curso curso) {		
		return new CourseModel(
				curso.getName(), 
				curso.getDescription(), 
				curso.getPrice(), 
				curso.getHours());
	}
	
	public Curso modelToEntity(CourseModel model) {
		return new Curso(
				model.getName(), 
				model.getDescription(), 
				model.getPrice(), 
				model.getHours());
	}
}
