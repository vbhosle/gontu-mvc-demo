package com.gontuseries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gontuseries.model.Student;

@Controller
public class StudentAdmissionController {
	
	@ModelAttribute
	public void addingCommonObjects(Model model) {
		//automatically binds all request paramters
		model.addAttribute("headerMsg", "Gontu Tutorials");
	}
	
	@RequestMapping(value="/admissionForm", method= {RequestMethod.GET})
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm", method = {RequestMethod.POST})
	public ModelAndView submitAdmissionForm(
//			@RequestParam("studentName") String name,
//			@RequestParam("studentHobby") String hobby
			@ModelAttribute("studentDetails") Student student,
			BindingResult result
	) 
	{
		if(result.hasErrors()) {
			//redirect to the form
			ModelAndView modelAndView = new ModelAndView("admissionForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admissionSubmitted");
		return modelAndView;
	}
}
