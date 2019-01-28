package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.udemy.repository.CursoJpaRepository;

@Component("exampleComponent")
public class ExampleComponent {
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;
	
	public void sayTest() {
		LOG.info("ExampleComponent_sayTest___RUN");
		LOG.info("Count all reisters "+cursoJpaRepository.count());
		LOG.info("ExampleComponent_sayTest___END");
	}
}
