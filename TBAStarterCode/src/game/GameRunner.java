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
	
	
	private void runGame() {
		
		System.out.println("Welcome to my game. What size board do want to play on? S, M, L: ");
    	
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
        player1.askForName(); 
        
        System.out.println("Welcome to the arena, " + player1.getName());
        
        
        
        
        boolean gameOn = true;
                
        while (gameOn) {
            
        	
            gameBoard.printBoard();

            // String move = player1.chooseMove();
            // Utilities.movePlayer(tech, player1,move);
            // gameOn = false;
          
            gameOn = false;
            
        }
		// in.close();
	}
	

}



