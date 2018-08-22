package aug17;

public class GenericEx2<T> {
	
	T v;
	
	public GenericEx2(T n) {
		v = n;
	}
	public void set(T n) {
		v = n;
	}
	public T get() {
		return v;
	}
	public static void main(String[] args) {
		GenericEx2<?> g2 = new GenericEx2<String>("String객체");
		String s = (String)g2.get();
		System.out.println("g2의 결과 : "+s);
		GenericEx2<?> g3 = new GenericEx2<Integer>(10000);
		System.out.println("g3의 결과  : "+g3.get().toString());
	}

}
