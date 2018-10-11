package com.gontuseries.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gontuseries.model.Student;

@RestController
public class StudentRESTController {

	//@ResponseBody //no need of it with RestController annotation
	@RequestMapping(value="/students",  method = {RequestMethod.GET})
	public ArrayList<Student> getStudentsList(){
		Student student1 = new Student();
		student1.setStudentName("Raj");
		
		Student student2 = new Student();
		student2.setStudentName("Tom");
		
		Student student3 = new Student();
		student3.setStudentName("Alex");
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		return list;
	}
	
	@RequestMapping(value="/students/{name}",  method = {RequestMethod.GET})
	public Student getStudent(@PathVariable("name") String studentName) {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("Music");
		return student;
	}
}
