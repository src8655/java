package aug03;

public class IfEx5 {

	public static void main(String[] args) {
		int jumsu = Integer.parseInt(args[0]);
		
		String res;
		
		if(jumsu >= 90 && jumsu <= 100)
			res = "A학점";
		else if(jumsu >= 80 && jumsu < 90)
			res = "B학점";
		else if(jumsu >= 70 && jumsu < 80)
			res = "C학점";
		else if(jumsu >= 60 && jumsu < 70)
			res = "D학점";
		else if(jumsu >= 50 && jumsu < 60)
			res = "E학점";
		else 
			res = "죽어라.";
		System.out.println(res);
	}

}
