package com.udemy.service;

import java.util.List;

import com.udemy.model.CourseModel;

public interface CourseService {	
	public abstract List<CourseModel> listAllCourses();
	public abstract CourseModel addCourse(CourseModel curso);
	public abstract boolean removeCourse(int id);
	public abstract CourseModel updateCourse(CourseModel curso);
}
