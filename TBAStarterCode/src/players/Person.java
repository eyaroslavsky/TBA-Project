package players;

import java.util.Scanner;

/**
 * Text Based Adventure Project
 * @author Edward Yaroslavsky periods 6-7 
 * 11/1/17
 */

public class Person {
	
	private String name;
	private int health;
	private int posX, posY;
	private int positionIndex;
	
	/**
	 * Constructor for creating a new player
	 * @param personPower sets the power for a new player
	 * @param personHealth sets the health for a new player
	 */
	public Person(int personHealth) {
		this.setHealth(personHealth);
	}
	public Person() {
		this.setHealth(50);
	}
	
	
	/**
	 * Asks the user their name
	 */
	public void askForName() {

		System.out.println("What's your name?");
		
		Scanner scName = new Scanner(System.in);
		String playerName = scName.nextLine();
		
		while (playerName.isEmpty()) {
			System.out.println("Sorry? What's your name?");
			playerName = scName.nextLine();
		}
    	
    	// System.out.println("Welcome to the game, " + playerName);	
		this.name = playerName;
		
	}
	
	/**
	 * Let's the user decide what direction they want to move
	 */
	public String chooseMove() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What's your move? use <W,A,S,D> keys.");
		while (!sc.hasNext("[WASDwasd]")) {
		    System.out.println("That's not correct, please try again. Use only <W,A,S,D> keys!");
		    sc.next();
		}
		String input = sc.next();

		return input;
	}
	
	
	public void setPosition(int x, int y, int l) {
		
		this.setPosX(x);
		this.setPosY(y);
		
		this.positionIndex = x*l + y;
		
	}
	
	
	/**
	 * Takes the private name and returns it so it can be used elsewhere
	 * @return name so it can be used outside of the class
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Constructor for the name
	 * @param name takes the String of the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Takes the private power and returns it so it can be used elsewhere
	 * @return power so it can be used outside of the class
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Constructor for the power
	 * @param power takes the integer of the power of the player
	 */

	public void setHealth(int health) {
		this.health = health;
	}
	
	
	public int getPositionIndex() {
		return positionIndex;
	}
	public void setPositionIndex(int positionIndex) {
		this.positionIndex = positionIndex;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}
