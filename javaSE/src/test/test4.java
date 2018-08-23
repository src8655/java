package test;

import java.util.*;

class Book2 {
	String category;
	String bookName;
	double bookPrice;
	double bookDiscountRate;
	
	Book2() {
		
	}
	Book2(String category, String bookName, double bookPrice, double bookDiscountRate) {
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookDiscountRate() {
		return bookDiscountRate;
	}
	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public String toString() {
		return bookName;
	}
	
}
public class test4 {

	public static void main(String[] args) {
		Book2[] bookArray = new Book2[5];
		bookArray[0] = new Book2("IT", "SQL Plus", 50000, 5);
		bookArray[1] = new Book2("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book2("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book2("Nobel", "divinchicode", 30000, 10);
		bookArray[4] = new Book2("Nobel", "cloven hoof", 50000, 15);
		
		HashMap map = new HashMap<>();

		map.put("it1", bookArray[0]);
		map.put("it2", bookArray[1]);
		map.put("it3", bookArray[2]);
		
		
		Set set = map.keySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key+"="+map.get(key).toString());
		}
	}

}
