package board;

import java.util.Arrays;
import java.util.Collections;

import rooms.*;

public class Board {


	public static final int SMALLBOARD = 5;
	public static final int MEDIUMBOARD = 7;
	public static final int LARGEBOARD = 9;
	
    private Room[][] rooms;
    private int boardSize = 0;
    

    public Board(int boardSizeInt) {

    	this.boardSize = boardSizeInt;
    	this.rooms = new Room[boardSize][boardSize];
       
    }

    public void printBoard() {
    
        for(Room[] row : rooms) {
        
            for (Room room : row) {
            
                room.print();
            }
            System.out.println();
        }
    }
    
    public Room[][] getRooms() {
        return rooms;
    }

    
    private int getXfromRoomIndex(int index) {
    	return (int) index/boardSize;
    }
    
    private int getYfromRoomIndex(int index) {
    	return index % boardSize;
    }
    
    private void createBadRoom(int randRoomIndex, int powerLevel, int roomLevel) {
		BadRoom e = new BadRoom(powerLevel, roomLevel);    			
		e.setIndex(randRoomIndex);			
		rooms[getXfromRoomIndex(randRoomIndex)][getYfromRoomIndex(randRoomIndex)] = e;
    }
    
    private void createPowerRoom(int randRoomIndex, int powerLevel, int roomLevel) {
    	PowerRoom e = new PowerRoom(powerLevel, roomLevel);    			
		e.setIndex(randRoomIndex);			
		rooms[getXfromRoomIndex(randRoomIndex)][getYfromRoomIndex(randRoomIndex)] = e;
    }
    
    public void generateRooms() {
    	
    	if (rooms == null)
    		return;
    	
    	// initially create all empty rooms
    	
		int index=0;
    	for (int x=0; x<rooms.length; x++) {
    		for (int y=0; y<rooms[x].length; y++) {
    			index++;
    			
    			EmptyRoom e = new EmptyRoom();
    			e.setIndex(index);
    			
    			rooms[x][y] = e;
    		}
    	}
    	
		// how many chance rooms do we need?
		
		int numHighRiskRooms = 0;
		int numMediumRiskRooms = 0;
		int numLowRiskRooms = 0;
		
		if (boardSize == Board.SMALLBOARD) {
			numHighRiskRooms = 0;
			numMediumRiskRooms = 5;
			numLowRiskRooms = 5;
		} else if (boardSize == Board.MEDIUMBOARD) {
			numHighRiskRooms = 5;
			numMediumRiskRooms = 10;
			numLowRiskRooms = 5;
		} else if (boardSize == Board.LARGEBOARD) {
			numHighRiskRooms = 10;
			numMediumRiskRooms = 10;
			numLowRiskRooms = 10;
		}
		
		int lastRoomIndex = boardSize*boardSize;
		
	    Integer[] randomRooms = new Integer[lastRoomIndex-3];
	    for (int i = 0; i < randomRooms.length; i++) {
	    	randomRooms[i] = i+1;
	    }
	    Collections.shuffle(Arrays.asList(randomRooms));
	    
	    // Lower risk room
	    for (int x=0; x<numLowRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x];
	    	// System.out.println("Low chance room: "+randRoomIndex);
	    	
	    	if ((Math.random() * 4) < 1) {
	    		createBadRoom(randRoomIndex, -10, Room.EASY);
	    	} else {	
	    		createPowerRoom(randRoomIndex, 10, Room.EASY);    
	    	}
	    	
	    }

	    // Medium risk room
	    for (int x=0 ; x<numMediumRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x+numLowRiskRooms];
	    	// System.out.println("Medium chance room: "+randRoomIndex);
	    	
	    	if ((Math.random() * 2) < 1) {
	    		createBadRoom(randRoomIndex, -10, Room.MEDIUM);
	    	} else {	
	    		createPowerRoom(randRoomIndex, 15, Room.MEDIUM);    
	    	}
	    	
	    }
    	
	    for (int x=0; x<numHighRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x+numLowRiskRooms+numMediumRiskRooms];
	    	// System.out.println("High chance room: "+randRoomIndex);

	    	if ((Math.random() * 4) >= 1) {
	    		createBadRoom(randRoomIndex, -10, Room.HARD);
	    	} else {	
	    		createPowerRoom(randRoomIndex, 20, Room.HARD);    
	    	}
	    }
    	
    	
    }
    

}
