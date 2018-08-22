package aug14;

class Product3 {
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}
class Tv6 extends Product3 {
	Tv6() {
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}
class Computer extends Product3 {
	Computer(){
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}
class Buyer {
	int money = 1000;
	
	int bonusPoint = 0;
	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		
		bonusPoint += p.bonusPoint;
		System.out.println(p+"을/를 구입하셨습니다.");
	}
}
public class PolyArgumentTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv6 tv = new Tv6();
		Computer com = new Computer();
		b.buy(tv);
		b.buy(com);
		System.out.println("현재 남은 돈은 "+b.money+"만원입니다.");
		System.out.println("현재 보너스점수는 "+b.bonusPoint+"점입니다.");
	}

}
