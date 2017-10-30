package rooms;

public class BadRoom extends Room {

	int powerLevel = 0;
	
	public BadRoom(int level) {
		this.powerLevel = level;
	}
	
	public BadRoom(int powerLevel, int roomLevel) {
		this.powerLevel = powerLevel;
		this.roomLevel = roomLevel;
	}
	
	@Override
	public void print() {
		
		// System.out.print("[" + powerLevel + " " + roomLevel + "]");
		System.out.print("[" + Room.ROOMLABEL[roomLevel] + "]");

	}

}
