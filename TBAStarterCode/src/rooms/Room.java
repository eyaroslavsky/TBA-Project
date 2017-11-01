package rooms;


public abstract class Room implements IPowerLevel {

	
	public static final int EMPTY = 0;
	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;
	
	public static final String[] ROOMLABEL = {" ", "E", "M", "H"};
	
	public static final int DEFAULT_ROOM_LEVEL = 10;
	
    private boolean explored = false;
    private int index;
    int roomLevel = Room.EMPTY;
	int powerLevel = 0;
    

    public abstract void print();
    
	public void print(boolean occupied) {
		if (occupied)
			System.out.print("[X]");
		else if (explored)
			System.out.print("[-]");
		else
			print();
	}
    

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public int getRoomLevel() {
		return roomLevel;
	}

	public void setRoomLevel(int roomLevel) {
		this.roomLevel = roomLevel;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}




}
