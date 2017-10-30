package rooms;

public class BadRoom extends Room {

	int powerLevel = 0;
	
	/**
	 * Constructor for the power level of the Bad Room
	 * @param level takes the integer of the level of the room
	 */
	public BadRoom(int level) {
		this.powerLevel = level;
	}
	
	/**
	 * Overloaded Constructor for the power level and room level of the room
	 * @param powerLevel takes the integer of the power level of the room
	 * @param roomLevel takes the integer of the room level of the room
	 */
	public BadRoom(int powerLevel, int roomLevel) {
		this.powerLevel = powerLevel;
		this.roomLevel = roomLevel;
	}
	
	/**
	 * Prints out the physical array of the room with its level for the Bad Room
	 */
	@Override
	public void print() {
		
		// System.out.print("[" + powerLevel + " " + roomLevel + "]");
		System.out.print("[" + Room.ROOMLABEL[roomLevel] + "]");

	}

}
