package aug08;

public class StaticTest3 {

	public static void main(String[] args) {
		StaticCount sc1 = new StaticCount();
		System.out.println("sc1의 c : "+sc1.c+", sc1의 count : "+StaticCount.count);

		StaticCount sc2 = new StaticCount();
		System.out.println("sc2의 c : "+sc2.c+", sc2의 count : "+StaticCount.count);

		StaticCount sc3 = new StaticCount();
		System.out.println("sc3의 c : "+sc3.c+", sc3의 count : "+StaticCount.count);
	}

}
