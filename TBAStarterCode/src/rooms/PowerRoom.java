package rooms;

public class PowerRoom extends Room {

	int powerLevel = 0;
	
	public PowerRoom(int level) {
		this.powerLevel = level;
	}
	
	public PowerRoom(int powerLevel, int roomLevel) {
		this.powerLevel = powerLevel;
		this.roomLevel = roomLevel;
	}
	
	@Override
	public void print() {
		
		// System.out.print("[" + powerLevel + " " + roomLevel + "]");
		
		System.out.print("[" + Room.ROOMLABEL[roomLevel] + "]");

	}

}
