package com.udemy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.entity.Curso;
import com.udemy.repository.CursoJpaRepository;
import com.udemy.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository courseServiceImpl;

	@Override
	public List<Curso> listAllCourses() {		
		return courseServiceImpl.findAll();
	}

	@Override
	public Curso addCourse(Curso curso) {		
		return courseServiceImpl.save(curso);
	}

	@Override
	public boolean removeCourse(int id) {
		courseServiceImpl.deleteById(id);
		return true;
	}

	@Override
	public Curso updateCourse(Curso curso) {		
		return courseServiceImpl.save(curso);
	}

}
