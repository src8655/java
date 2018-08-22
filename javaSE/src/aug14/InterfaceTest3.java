package aug14;

public class InterfaceTest3 {

	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA();
	}

}

class A3 {
	void methodA() {
		I2 i = InstanceManager.getInstance();
		i.methodB();
	}
}
interface I2 {
	public abstract void methodB();
}
class B3 implements I2 {
	public void methodB() {
		System.out.println("methodB in B class");
	}
}
class InstanceManager {
	public static I2 getInstance() {
		return new B3();
	}
}
