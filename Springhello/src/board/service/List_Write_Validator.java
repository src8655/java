package board.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import board.model.List_Data;


public class List_Write_Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return List_Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		List_Data ldata = (List_Data)target;

		if(ldata.getSubject() == null||ldata.getSubject().equals(""))
			error.rejectValue("subject", "required");
		if(ldata.getName() == null||ldata.getName().equals(""))
			error.rejectValue("name", "required");
		if(ldata.getPassword() == null||ldata.getPassword().equals(""))
			error.rejectValue("password", "required");
		
	}

}
