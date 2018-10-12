package hello;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String name;
	private String msg = "empty";
	

	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}

	@Override
	public String execute() throws Exception {
		msg = "Hello, " + name;
		return SUCCESS;
	}

}
