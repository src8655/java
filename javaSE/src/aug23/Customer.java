package aug23;

public class Customer implements java.io.Serializable {
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "당신의 이름 : "+name;
	}
}
