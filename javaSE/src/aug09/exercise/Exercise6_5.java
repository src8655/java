package aug09.exercise;

public class Exercise6_5 {

	public static void main(String[] args) {
		Student2 s = new Student2("ȫ�浿", 1, 1, 100, 60, 76);
		
		System.out.println(s.info());
	}

}
class Student2 {
	String name;
	int ban, no, kor, eng, math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return (kor+eng+math);
	}
	float getAverage() {
		return Math.round((kor+eng+math)/3.0f*10f)/10f;
	}
	
	String info() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}
}