package test;

class Book {
	private String category;
	private String bookName;
	private double bookPrice;
	private double bookDiscountRate;
	
	Book() {
		
	}
	Book(String category, String bookName, double bookPrice, double bookDiscountRate) {
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
	
}
public class test2 {

	public static void main(String[] args) {
		Book[] bookArray = new Book[5];
		bookArray[0] = new Book("IT", "SQL Plus", 50000, 5);
		bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book("Nobel", "divinchicode", 30000, 10);
		bookArray[4] = new Book("Nobel", "cloven hoof", 50000, 15);
		
		double sum = 0;
		for(int i=0;i<bookArray.length;i++) {
			System.out.println(bookArray[i].getCategory()+" "+bookArray[i].getBookName()
					+"원\t"+bookArray[i].getBookPrice()+" "+bookArray[i].getBookDiscountRate()+"%");
			sum += bookArray[i].getBookPrice();
		}
		System.out.println();
		System.out.println("책 가격의 합 : "+sum+"원");
	}

}
