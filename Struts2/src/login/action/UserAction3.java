package login.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import login.dao.UserDao;
import login.model.UserInfo;

public class UserAction3 implements Action, Preparable, ModelDriven {
	UserInfo userInfo;
	
	@Override
	public String execute() throws Exception {
		UserDao loginDao =new UserDao();
    	
    	if (loginDao.save(userInfo)) 
    		return SUCCESS;
    	else 
    		return ERROR;
	}
	
	
	public UserInfo getUserInfo() {
		return userInfo;
	}


	@Override
	public Object getModel() {
		return userInfo;
	}

	@Override
	public void prepare() throws Exception {
		userInfo = new UserInfo();
	}

	

}
