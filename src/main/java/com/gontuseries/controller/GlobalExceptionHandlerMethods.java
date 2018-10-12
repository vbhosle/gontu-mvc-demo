package com.gontuseries.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {

	@ExceptionHandler(value=IllegalArgumentException.class)
	public String illigalArgument(Exception e) {
		System.out.println("IllegalArgumentException "+ e);
		return "errors/IllegalArgumentException";
	}
}
