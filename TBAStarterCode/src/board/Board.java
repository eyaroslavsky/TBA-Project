package board;
//
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
    
    public void generateRooms() {
    	
    	if (rooms == null)
    		return;
    	
    	// intially create all emty rooms
    	
		int index=0;
    	for (int x=0; x<rooms.length; x++) {
    		for (int y=0; y<rooms[x].length; y++) {
    			index++;
    			
    			EmptyRoom e = new EmptyRoom();
    			e.setX(x);
    			e.setY(y);
    			e.setIndex(index);
    			
    			rooms[x][y] = e;
    		}
    	}
    	
		// how many chance rooms do we need?
		
		int numChanceRooms = 0;
		int numHighRiskRooms = 0;
		int numMediumRiskRooms = 0;
		int numLowRiskRooms = 0;
		
		if (boardSize == Board.SMALLBOARD) {
			numChanceRooms = 10;
			numHighRiskRooms = 0;
			numMediumRiskRooms = 5;
			numLowRiskRooms = 5;
		} else if (boardSize == Board.MEDIUMBOARD) {
			numChanceRooms = 20;
			numHighRiskRooms = 5;
			numMediumRiskRooms = 10;
			numLowRiskRooms = 5;
		} else if (boardSize == Board.LARGEBOARD) {
			numChanceRooms = 30;
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

	    
	    for (int x=0; x<numLowRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x];
	    	// System.out.println("Low chance room: "+randRoomIndex);
	    	
	    	boolean isPowerRoom = false;
	    	if (isPowerRoom) {
	    		
	    		PowerRoom e = new PowerRoom();    			
    			e.setIndex(randRoomIndex);			
    			rooms[getXfromRoomIndex(randRoomIndex)][getYfromRoomIndex(randRoomIndex)] = e;
    			
	    	} else {
	    		
	    		
	    		BadRoom e = new BadRoom();    			
    			e.setIndex(randRoomIndex);			
    			rooms[getXfromRoomIndex(randRoomIndex)][getYfromRoomIndex(randRoomIndex)] = e;
	    		
	    	}
	    	
	    }

	    for (int x=0 ; x<numMediumRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x+numLowRiskRooms];
	    	// System.out.println("Medium chance room: "+randRoomIndex);
	    }
    	
	    for (int x=0; x<numHighRiskRooms; x++) {
	    	int randRoomIndex = randomRooms[x+numLowRiskRooms+numMediumRiskRooms];
	    	// System.out.println("High chance room: "+randRoomIndex);
	    }
    	
    	
    }
    

}
