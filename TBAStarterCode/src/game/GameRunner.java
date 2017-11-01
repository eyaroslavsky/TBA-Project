package game;

import java.util.Scanner;

import board.Board;
import rooms.Room;
import players.Person;

// by Edward Yaroslavsky

public class GameRunner {

	
    public static void main (String[] args) {

    	GameRunner gr = new GameRunner();
    	gr.runGame();
    	
    	System.exit(0);
    }
	
	/**
	 * Starts the game, creates the board size depending on user input, and continues the game
	 */
	private void runGame() {
		
		System.out.println("Welcome to my game! "
				+ "\nIn this game, you start off with 50 health points and must make it to the opposite corner of the board in order to win or lose."
				+ "\nTo win, you must obtain at least 100 health points when you reach the end. Otherwise, you will lose. If you reach below 0 points, you will also lose."
				+ "\nRooms labeled with an 'E' represent an easy room with a higher chance of success, although it's not as rewarding."
				+ "\nRooms labeled with an 'M' represent a medium room with an average chance of success and average rewards."
				+ "\nRooms labeled with an 'H' represent a hard room with an low chance of success, although they are more rewarding."
				+ "\nYou will be represented by the character 'X'.");
		System.out.println("What size board do want to play on? "
				+ "\nType in 'S', 'M', or 'L' to play on either a small, medium, or large board: ");
    	
    	Scanner sc = new Scanner(System.in);
    	String boardSize = sc.nextLine();
    			
    	while (!boardSize.equalsIgnoreCase("S") && !boardSize.equalsIgnoreCase("M") && !boardSize.equalsIgnoreCase("L")) {
    		System.out.println("Please select only S, M, L: ");
    		boardSize = sc.nextLine();    		
    		
    	}
    	// sc.close();
    	
    	
    	int boardSizeInt;
    	if (boardSize.equalsIgnoreCase("S")) 
    		boardSizeInt = Board.SMALLBOARD;
    	else if (boardSize.equalsIgnoreCase("M"))
    		boardSizeInt = Board.MEDIUMBOARD;
    	else
    		boardSizeInt = Board.LARGEBOARD;
    	
    	System.out.println("You've selected board of size: " + boardSize + " (" + boardSizeInt+"x"+boardSizeInt+")");
    		
    	
    	// Generating room based on the size selected
        Board gameBoard = new Board(boardSizeInt);
        gameBoard.generateRooms();
        
        // Getting person info
        Person player1 = new Person();
        player1.setPosition(0, 0, boardSizeInt);
        
        Room room = gameBoard.getRooms()[0][0];
        room.setExplored(true);
        
        player1.askForName(); 
        
        
        gameBoard.setPlayer(player1);
        System.out.println("Welcome to the arena, " + player1.getName());
        
        
        
        
        boolean gameOn = true;
                
        while (gameOn) {
            
        	
            gameBoard.printBoard();
            
            System.out.println("Your Health is at: " + player1.getHealth() + " points");

            String move = player1.chooseMove();
            
    		if (move.equalsIgnoreCase("A")) {
    			
    			if (player1.getPosY()  > 0) 
    				player1.setPosition(player1.getPosX(), player1.getPosY()-1, boardSizeInt);    		
    			
    		} else if (move.equalsIgnoreCase("W")) {
    			
    			if (player1.getPosX() > 0) 
    				player1.setPosition(player1.getPosX()-1, player1.getPosY(), boardSizeInt);
    			
    		} else if (move.equalsIgnoreCase("D")) {		
    			
    			if (player1.getPosY() < boardSizeInt-1) 
    				player1.setPosition(player1.getPosX(), player1.getPosY()+1, boardSizeInt);    	
    			
    		} else if (move.equalsIgnoreCase("S")) {
    			
    			if (player1.getPosX() < boardSizeInt-1) 
    				player1.setPosition(player1.getPosX()+1, player1.getPosY(), boardSizeInt);
    				
    		}
    		
    		Room nextRoom = gameBoard.getRooms()[player1.getPosX()][player1.getPosY()];
            nextRoom.setExplored(true);
             
            int roomPower = nextRoom.getPowerValue();
            player1.setHealth(player1.getHealth()+roomPower);
            
            if (nextRoom.getRoomLevel() != Room.EMPTY) {
            	System.out.println("Your entered an: " + Room.ROOMLABEL[nextRoom.getRoomLevel()] + " room. You received: " + roomPower + " points");
            } 
            
            if (player1.getHealth() < 0) {
            	gameOn = false;
            	gameBoard.printBoard();
            	System.out.println("Game over. You do not have any more points to spend. You Lose");
            }
            
            if ((player1.getPosX() == boardSizeInt - 1) && (player1.getPosY() == boardSizeInt - 1)) {
            	gameOn = false;
            	gameBoard.printBoard();
            	if (player1.getHealth() >= 100) {
            		System.out.println("Congratulations! You have won the game!");
            	}
            	else {
            		System.out.println("Game over. You have not received enough points. You Lose");
            	}
            }
        }
        
        sc.close();
        System.out.println("Thank you for playing, " + player1.getName());
	}
	

}



