package rooms;

public class BadRoom extends Room {

	int powerLevel = 1;
	
	@Override
	public void print() {
		
		System.out.print("[" + powerLevel + "]");

	}

}
