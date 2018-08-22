package aug07.aTt;

public class ReferenceParameter {
	public void increase(int[] n) {
		for(int i=0;i<n.length;i++) {
			n[i]++;
			System.out.println("n["+i+"] : "+n[i]);
		}
	}
	public static void main(String[] args) {
		int[] ref1 = {100,800,1000};
		ReferenceParameter rp = new ReferenceParameter();
		rp.increase(ref1);
		for(int i=0;i<ref1.length;i++)
			System.out.println("ref1["+i+"] : "+ref1[i]);
	}

}
