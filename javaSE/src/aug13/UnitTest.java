package aug13;

public class UnitTest {

	public static void main(String[] args) {
		Unit u = new Zerg("Hydralisk", false);
		u.decEnerge();
		System.out.println("z1�� Energe : "+u.getEnerge());
		
		u = new Protoss("Corsair", true);
		u.decEnerge();
		System.out.println("p1�� Energe : "+u.getEnerge());
		
		u = new Terran("Marine",false);
		u.decEnerge();
		System.out.println("t1�� Energe : "+u.getEnerge());
	}

}
