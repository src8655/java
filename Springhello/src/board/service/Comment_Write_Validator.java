package board.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import board.model.Comment_Data;
import board.model.List_Data;


public class Comment_Write_Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Comment_Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Comment_Data cdata = (Comment_Data)target;
		
		if(cdata.getName() == null||cdata.getName().equals(""))
			error.rejectValue("name", "이름을 입력해 주세요.");
		if(cdata.getPassword() == null||cdata.getPassword().equals(""))
			error.rejectValue("password", "비밀번호를 입력해 주세요.");
		if(cdata.getMemo() == null||cdata.getMemo().equals(""))
			error.rejectValue("memo", "내용을 입력해 주세요.");
		
	}

}
