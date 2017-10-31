package rooms;

public class PowerRoom extends Room {

	
	/**
	 * Constructor for the power level of the Power Room
	 * @param level takes the integer of the level of the room
	 */
	public PowerRoom(int level) {
		this.powerLevel = level;
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
		
		// System.out.print("[" + powerLevel + " " + roomLevel + "]");		
		System.out.print("[" + Room.ROOMLABEL[roomLevel] + "]");

	}


}
