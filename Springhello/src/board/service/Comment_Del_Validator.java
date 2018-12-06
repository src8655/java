package board.service;

import java.util.*;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import board.Md5Enc;
import board.model.Comment_Data;
import board.model.List_Data;


public class Comment_Del_Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Comment_Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Comment_Data cdata = (Comment_Data)target;
		
		if(cdata.getPassword() == null||cdata.getPassword().equals(Md5Enc.getEncMD5("".getBytes())))
			error.rejectValue("password", "��й�ȣ�� �Է����ּ���.");
		else if(!cdata.getPassword().equals(cdata.getPassword2()))
			error.rejectValue("password", "��й�ȣ�� �ٸ��ϴ�.");
		
	}

}
