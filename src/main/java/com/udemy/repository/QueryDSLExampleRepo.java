package com.udemy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Curso;
import com.udemy.entity.QCurso;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	private static final Log LOG = LogFactory.getLog(QueryDSLExampleRepo.class);

	QCurso qCurso = QCurso.curso;

	@PersistenceContext
	private EntityManager em;

	public void find(boolean existe) {
		JPAQuery<Curso> query = new JPAQuery<>(em);
		BooleanBuilder builder = new BooleanBuilder(qCurso.description.endsWith("OP"));
		if (existe)
			builder.and(qCurso.id.eq(23));
		else
			builder.or(qCurso.hours.between(20, 50));
		Curso curso = query.select(qCurso).from(qCurso).where(builder).fetchOne();
		LOG.info(curso);

	}
}
