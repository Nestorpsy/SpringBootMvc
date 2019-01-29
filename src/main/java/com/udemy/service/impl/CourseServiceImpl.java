package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Curso;
import com.udemy.model.CourseModel;
import com.udemy.repository.CursoJpaRepository;
import com.udemy.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository courseServiceImpl;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		List<Curso> listCurso  = courseServiceImpl.findAll();
		List<CourseModel> listModel = new ArrayList<>();
		if(listCurso == null || listCurso.isEmpty())
			return listModel;		
		for(Curso curso:listCurso)
			listModel.add(courseConverter.entityToModel(curso));
		return listModel;
	}

	@Override
	public CourseModel addCourse(CourseModel model) {
		Curso curso = courseServiceImpl.save(courseConverter.modelToEntity(model));
		return courseConverter.entityToModel(curso);
	}

	@Override
	public boolean removeCourse(int id) {
		courseServiceImpl.deleteById(id);
		return true;
	}

	@Override
	public CourseModel updateCourse(CourseModel model) {		
		Curso curso = courseServiceImpl.save(courseConverter.modelToEntity(model));
		return courseConverter.entityToModel(curso);
	}

}
