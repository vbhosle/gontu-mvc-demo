package com.gontuseries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gontuseries.model.Student;
import com.gontuseries.services.StudentService;

@RestController
public class StudentRESTController {

	@Autowired
	private StudentService studentService;
	
	//@ResponseBody //no need of it with RestController annotation
	@RequestMapping(value="/students",  method = {RequestMethod.GET}, produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Student> getStudentsList(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value="/students/{name}",  method = {RequestMethod.GET})
	public ResponseEntity<Student> getStudent(@PathVariable("name") String studentName) {
		Student student = studentService.getStudentByName(studentName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("customHeader", "customHeaderValue");
		if(student == null)
			return new ResponseEntity<Student>(student, headers, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Student>(student, headers, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/students/{name}", method = {RequestMethod.PUT}, consumes= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public boolean updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
		System.out.println("Student update received for: " + studentName);
		System.out.println("Student name: " + student.getStudentName() + ", Student Hobby: " + student.getStudentHobby());
		
		//update the student record
		student.setStudentName(studentName);
		return studentService.updateStudent(student);
	}
	
	@RequestMapping(value="/students",  method = {RequestMethod.POST})
	public ResponseEntity<Boolean> addStudent(@RequestBody Student student) {
		boolean result = studentService.addStudent(student);
		if(result) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("location", ServletUriComponentsBuilder
									.fromCurrentRequest()
									.path("/{name}")
									.buildAndExpand(student.getStudentName())
									.toUri()
									.toString()
					);
			return new ResponseEntity<Boolean>(result, headers, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Boolean>(result, HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping(value="/students/{name}", method = {RequestMethod.DELETE})
	public ResponseEntity<Void> deleteStudent(@PathVariable("name") String studentName) {
		System.out.println("Student delete received for: " + studentName);
		boolean result = studentService.deleteStudent(studentName);
		if(result) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
