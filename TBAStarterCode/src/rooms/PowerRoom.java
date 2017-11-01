package rooms;

/**
 * Text Based Adventure Project
 * @author Edward Yaroslavsky periods 6-7 
 * 11/1/17
 */

public class PowerRoom extends Room {

	/**
	 * Constructor for the power level of the Power Room
	 * @param level takes the integer of the level of the room
	 */
	public PowerRoom(int roomLevel) {
		this.roomLevel = roomLevel;
	}
	
	/**
	 * Overloaded Constructor for the power level and room level of the room
	 * @param powerLevel takes the integer of the power level of the room
	 * @param roomLevel takes the integer of the room level of the room
	 */
	public PowerRoom(int powerLevel, int roomLevel) {
		this.powerLevel = powerLevel;
		this.roomLevel = roomLevel;
	}
	
	/**
	 * Prints out the physical array of the room with its level for the Power Room
	 */
	@Override
	public void print() {	
		System.out.print("[" + Room.ROOMLABEL[roomLevel] + "]");
	}
	
	/**
	 * Takes a random factor to multiply the power of the rooms by
	 * @return the power level of the room multiplied by the randomly generated factor
	 */
	@Override
	public int getPowerValue() {
		// random between 1 and 2
		int factor = 1 + (int)(Math.random() * 3);
		
		return powerLevel * factor;
	}


}
