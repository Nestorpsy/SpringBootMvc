package com.udemy.service;

import java.util.List;

import com.udemy.entity.Curso;

public interface CourseService {	
	public abstract List<Curso> listAllCourses();
	public abstract Curso addCourse(Curso curso);
	public abstract boolean removeCourse(int id);
	public abstract Curso updateCourse(Curso curso);
}
