package rooms;

public class EmptyRoom extends Room {
	
	/**
	 * Prints out the physical array of the empty room
	 */
	@Override
	public void print() {
		
		System.out.print("[ ]");

	}

	@Override
	public int getPowerValue() {
		// no adjustments for empty room
		return powerLevel;	
	}
	

}
