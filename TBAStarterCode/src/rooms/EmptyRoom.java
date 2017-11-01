package rooms;

/**
 * Text Based Adventure Project
 * @author Edward Yaroslavsky periods 6-7 
 * 11/1/17
 */

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
