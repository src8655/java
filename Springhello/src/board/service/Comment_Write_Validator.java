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
			error.rejectValue("name", "�̸��� �Է��� �ּ���.");
		if(cdata.getPassword() == null||cdata.getPassword().equals(""))
			error.rejectValue("password", "��й�ȣ�� �Է��� �ּ���.");
		if(cdata.getMemo() == null||cdata.getMemo().equals(""))
			error.rejectValue("memo", "������ �Է��� �ּ���.");
		
	}

}
