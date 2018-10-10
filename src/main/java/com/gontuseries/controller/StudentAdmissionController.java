package com.gontuseries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	@RequestMapping(value="/admissionForm", method= {RequestMethod.GET})
	public ModelAndView getAdmissionForm() {
		System.out.println("hello");
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm", method = {RequestMethod.POST})
	public ModelAndView submitAdmissionForm(
			@RequestParam("studentName") String name,
			@RequestParam("studentHobby") String hobby
	) 
	{
		ModelAndView modelAndView = new ModelAndView("admissionSubmitted");
		modelAndView.addObject("msg", "Details submitted by you - name:" + name + ", hobby:" + hobby);
		return modelAndView;
	}
}
