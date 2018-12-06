package board.service;

import java.util.*;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import board.Md5Enc;
import board.model.List_Data;


public class List_Del_Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return List_Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		List_Data ldata = (List_Data)target;
		
		if(ldata.getPassword() == null||ldata.getPassword().equals(Md5Enc.getEncMD5("".getBytes())))
			error.rejectValue("password", "required");
		else if(!ldata.getPassword().equals(ldata.getPassword2()))
			error.rejectValue("password", "different");
		
	}

}
