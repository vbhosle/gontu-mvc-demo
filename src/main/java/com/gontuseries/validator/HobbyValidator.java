package com.gontuseries.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

	public void initialize(IsValidHobby isValidHobby) {
		// TODO Auto-generated method stub
	}
	
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if(studentHobby == null) {
			return false;
		}
		
		if(studentHobby.matches("Music|Football|Cricket|Hockey")) {
			return true;
		}
		else {
			return false;
		}
	}

}
