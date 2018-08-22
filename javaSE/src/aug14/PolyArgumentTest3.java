package aug14;

import java.util.Vector;

class Tv8 extends Product4 {
	Tv8() {super(100);}
	public String toString() {return "Tv";}
}
class Computer3 extends Product4 {
	Computer3() {super(200);}
	public String toString() {return "Computer";}
}
class Audio2 extends Product4 {
	Audio2() {super(50);}
	public String toString() {return "Audio";}
}
class Buyer3 {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();
	
	void buy(Product4 p) {
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		money -= p.price;
		
		bonusPoint += p.bonusPoint;
		item.add(p);
		
		System.out.println(p+"��/�� �����ϼ̽��ϴ�.");
	}
	
	void refund(Product4 p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "��/�� ��ǰ�ϼ̽��ϴ�.");
		}else {
			System.out.println("�����Ͻ� ��ǰ �� �ش� ��ǰ�� �����ϴ�.");
		}
	}
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {
			System.out.println("�����Ͻ� ��ǰ�� �����ϴ�.");
			return;
			
		}
		for(int i=0;i<item.size();i++) {
			Product4 p = (Product4)item.get(i);
			sum += p.price;
			itemList += (i == 0) ? "" + p:", "+p;
		}
		System.out.println("�����Ͻ� ��ǰ�� �ѱݾ��� "+sum+"�����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� "+itemList+"�Դϴ�.");
	}
}
public class PolyArgumentTest3 {

	public static void main(String[] args) {
		Buyer3 b = new Buyer3();
		Tv8 tv = new Tv8();
		Computer3 com = new Computer3();
		Audio2 audio = new Audio2();

		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
		
	}

}
