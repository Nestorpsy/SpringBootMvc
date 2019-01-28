package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Curso;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {	
	private static final Log LOG  = LogFactory.getLog(CourseController.class);
	private static final String COURSES_HOME = "courses";
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;

	@GetMapping("/listCourses")
	public ModelAndView liastAllCourses() {
		LOG.info("CourseController_liastAllCourses___RUN");
		ModelAndView view = new ModelAndView(COURSES_HOME);
		view.addObject("coursesList",courseService.listAllCourses());
		LOG.info("CourseController_liastAllCourses___END");
		return view;
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") Curso curso) {
		LOG.info("CourseController_addCourse___RUN");
		courseService.addCourse(curso);
		LOG.info("CourseController_addCourse___END");
		return "redirect:/courses/listCourses";
	}
}
