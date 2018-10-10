package com.gontuseries.model;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		System.out.println("in custom editor");
		if(name.contains("Mr.") || name.contains("Ms.")) {
			setValue(name);
		}
		else {
			setValue("Ms. " + name);
		}
	}
}
