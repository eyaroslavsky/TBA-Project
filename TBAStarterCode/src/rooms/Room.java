package rooms;

/**
 * Text Based Adventure Project
 * @author Edward Yaroslavsky periods 6-7 
 * 11/1/17
 */

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
    
	/**
	 * The abstract print method to be used by sub classes
	 */
    public abstract void print();
    
    /**
     * Prints if the specific room is explored or occupied
     * @param occupied takes the boolean of whether the room the user traveled to is occupied
     */
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
