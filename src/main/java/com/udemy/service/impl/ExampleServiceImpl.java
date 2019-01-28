package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		LOG.info("ExampleServiceImpl-getListPeople___RUN");
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Juan", 19));
		persons.add(new Person("Alex", 20));
		persons.add(new Person("Luis", 29));
		persons.add(new Person("Beto", 25));
		persons.add(new Person("Ness", 27));
		LOG.info("ExampleServiceImpl-getListPeople___END");
		return persons;
	}

}
