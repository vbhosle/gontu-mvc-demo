package com.gontuseries.model;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gontuseries.validator.IsValidHobby;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills", "studentAddress"})
@JsonPropertyOrder({"student_name","studentDOB", "studentMobile", "studentAddress", "studentHobby", "studentSkills"})
public class Student {
	@JsonProperty("student_name")
	@Pattern(regexp="[^0-9]*")
	private String studentName;
	
//	@Size(min=2, max=30, message="hobby must be described between {min} to {max} words")
	@Size(min=2, max=30) //error message specified in properties file
	@IsValidHobby(listOfValidHobbies="Music|Cricket")
	private String studentHobby;
	
	@Max(2222)
	private Long studentMobile;
	
	@Past
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Address studentAddress;
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	
	
	
}
