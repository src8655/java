package aug14;

public class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public boolean equals(Object obj) {
		boolean result = false;
		if((obj != null) && (obj instanceof Product)) {
			Product p = (Product) obj;
			if((name.equals(p.name)) && (price == p.price))
				result = true;
		}
		return result;
	}
	@Override
	public int hashCode() {
		return ((name.hashCode()) ^ (new Integer(price).hashCode()));
	}
	@Override
	public String toString() {
		return name;
	}
	
}
