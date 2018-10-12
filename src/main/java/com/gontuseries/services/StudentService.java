package com.gontuseries.services;

import java.util.*;

import com.gontuseries.model.Address;
import com.gontuseries.model.Student;

public class StudentService {

	private static Map<String,Student> students = new HashMap<String,Student>();
	
	static {
		
		students.put("Raj", createStudent("Raj"));
		students.put("Tom", createStudent("Tom"));
		students.put("Alex", createStudent("Alex"));
	}
	
	public static Student createStudent(String name) {
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby("music");
		student.setStudentMobile(new Long(4343434));
		ArrayList<String> skills= new ArrayList<String>();
		skills.add("dance");
		skills.add("sing");
		student.setStudentSkills(skills);
		student.setStudentDOB(new Date());
		student.setStudentAddress(createAddress());
		return student;
	}
	
	public static Address createAddress() {
		Address address = new Address();
		address.setCountry("India");
		address.setCity("Mumbai");
		address.setPincode(400000);
		address.setStreet("abc street");
		return address;
	}
	public boolean addStudent(Student student) {
		if(student == null || student.getStudentName() == null || students.get(student.getStudentName())!=null)
			return false;
		students.put(student.getStudentName(), student);
		return true;
	}
	
	public boolean updateStudent(Student student) {
		if(student == null || student.getStudentName() == null || students.get(student.getStudentName())==null)
			return false;
		students.put(student.getStudentName(), student);
		return true;
	}
	
	public boolean deleteStudent(String name) {
		if(name == null || students.get(name)==null)
			return false;
		students.remove(name);
		return true;
	}
	
	public Student getStudentByName(String name) {
		if(name == null)
			return null;
		return students.get(name);
	}
	
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(students.values());
	}
	
}
