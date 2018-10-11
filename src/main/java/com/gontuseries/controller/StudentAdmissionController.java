package com.gontuseries.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gontuseries.model.Student;
import com.gontuseries.model.StudentNameEditor;

@Controller
public class StudentAdmissionController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("StudentAdmissionController: InitBinder");
		binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		binder.registerCustomEditor(Date.class,"studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model) {
		//automatically binds all request paramters
		System.out.println("StudentAdmissionController: addingCommonObjects");
		model.addAttribute("headerMsg", "Gontu Tutorials");
	}
	
	@RequestMapping(value="/admissionForm", method= {RequestMethod.GET})
	public ModelAndView getAdmissionForm() {
		System.out.println("StudentAdmissionController: getAdmissionForm");
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value="/submitAdmissionForm", method = {RequestMethod.POST})
	public ModelAndView submitAdmissionForm(
//			@RequestParam("studentName") String name,
//			@RequestParam("studentHobby") String hobby
			@Valid @ModelAttribute("studentDetails") Student student,
			BindingResult result
	) 
	{
		System.out.println("StudentAdmissionController: submitAdmissionForm");

		if(result.hasErrors()) {
			//redirect to the form
			ModelAndView modelAndView = new ModelAndView("admissionForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admissionSubmitted");
		return modelAndView;
	}
}
