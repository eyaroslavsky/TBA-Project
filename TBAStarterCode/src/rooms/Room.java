package rooms;


public abstract class Room {

	
	public static final int EASY = 0;
	public static final int MEDIUM = 1;
	public static final int HARD = 2;
	
	public static final String[] ROOMLABEL = {"E", "M", "H"};
	
    public boolean explored = false;
    private int index;
    int roomLevel = Room.EASY;
    

    public abstract void print();
    

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}




}
