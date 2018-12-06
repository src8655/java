package board.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import board.Md5Enc;
import board.model.List_Data;


public class List_Edit_Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return List_Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		List_Data ldata = (List_Data)target;

		if(ldata.getSubject() == null||ldata.getSubject().equals(""))
			error.rejectValue("subject", "������ �Է��� �ּ���.");
		if(ldata.getName() == null||ldata.getName().equals(""))
			error.rejectValue("name", "�̸��� �Է��� �ּ���.");
		if(ldata.getPassword() == null||ldata.getPassword().equals(Md5Enc.getEncMD5("".getBytes())))
			error.rejectValue("password", "��й�ȣ�� �Է��� �ּ���.");
		if(!ldata.getPassword().equals(ldata.getPassword2()))
			error.rejectValue("password", "��й�ȣ�� �ٸ��ϴ�.");
		
	}

}
