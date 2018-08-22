package aug14;

public class ProductEx1 {

	public static void main(String[] args) {
		Product p1 = new Product("En,Ca", 7078);
		Product p2 = new Product("En,Ca", 7078);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println("p1 hashCode : "+p1.hashCode()+" , p1 : "+p1.toString());
		System.out.println("p2 hashCode : "+p2.hashCode()+" , p2 : "+p2.toString());
	}

}
