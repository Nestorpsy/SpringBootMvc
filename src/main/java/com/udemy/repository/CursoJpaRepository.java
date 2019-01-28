package com.udemy.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Curso;

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable>{
	
	public abstract Curso findByPrice(int price);
	
	public abstract Curso findByPriceAndName(int price, String name);
	
	public abstract List<Curso> findByNameOrderByHours(String name);
	
	public abstract Curso findByNameOrPrice(String name, int price); 

}
