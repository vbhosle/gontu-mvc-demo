package com.gontuseries.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

	private String listOfValidHobbies;
	
	public void initialize(IsValidHobby isValidHobby) {
		listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}
	
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches(listOfValidHobbies)) {
			return true;
		}
		else {
			return false;
		}
	}

}
