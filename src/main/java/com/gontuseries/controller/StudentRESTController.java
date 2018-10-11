package com.gontuseries.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gontuseries.model.Student;
import com.gontuseries.services.StudentService;

@RestController
public class StudentRESTController {

	@Autowired
	private StudentService studentService;
	
	//@ResponseBody //no need of it with RestController annotation
	@RequestMapping(value="/students",  method = {RequestMethod.GET}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Student> getStudentsList(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value="/students/{name}",  method = {RequestMethod.GET})
	public Student getStudent(@PathVariable("name") String studentName) {
		return studentService.getStudentByName(studentName);
	}
	
	@RequestMapping(value="/students/{name}", method = {RequestMethod.PUT})
	public boolean updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
		System.out.println("Student update received for: " + studentName);
		System.out.println("Student name: " + student.getStudentName() + ", Student Hobby: " + student.getStudentHobby());
		
		//update the student record
		student.setStudentName(studentName);
		return studentService.updateStudent(student);
	}
}
