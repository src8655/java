package aug13;

class Parent {
	String msg = "Parent Ŭ����";
	public String getMsg() {
		return msg;
	}
}
class Child extends Parent {
	String msg = "Child Ŭ����";
	public String getMsg() {
		return msg;
	}
}
public class OverridingEx {

	public static void main(String[] args) {
		Child cd = new Child();
		System.out.println("cd : "+cd.getMsg());
		
		Parent pt = new Child();
		System.out.println("pt : "+pt.getMsg());
		

		Parent ct = new Parent();
		System.out.println("ct : "+ct.getMsg());
	}

}
