package aug03;

public class IfEx5 {

	public static void main(String[] args) {
		int jumsu = Integer.parseInt(args[0]);
		
		String res;
		
		if(jumsu >= 90 && jumsu <= 100)
			res = "A����";
		else if(jumsu >= 80 && jumsu < 90)
			res = "B����";
		else if(jumsu >= 70 && jumsu < 80)
			res = "C����";
		else if(jumsu >= 60 && jumsu < 70)
			res = "D����";
		else if(jumsu >= 50 && jumsu < 60)
			res = "E����";
		else 
			res = "�׾��.";
		System.out.println(res);
	}

}
