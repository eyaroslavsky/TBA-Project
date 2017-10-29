package rooms;

public class PowerRoom extends Room {

	int powerLevel = 10;
	
	@Override
	public void print() {
		
		System.out.print("[" + powerLevel + "]");

	}

}
