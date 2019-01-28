package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Errors {
	
	@ExceptionHandler(Exception.class)
	public String erroGeneric() {
		return "error/500";
	}

}
