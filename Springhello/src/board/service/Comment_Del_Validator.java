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
			error.rejectValue("password", "비밀번호를 입력해주세요.");
		else if(!cdata.getPassword().equals(cdata.getPassword2()))
			error.rejectValue("password", "비밀번호가 다릅니다.");
		
	}

}
