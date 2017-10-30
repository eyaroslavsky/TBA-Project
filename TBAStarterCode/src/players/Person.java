package players;

import java.util.Scanner;

public class Person {
	
	private String name;
	private int power;
	private int health;
	private int posX, posY;
	
	/**
	 * Constructor for creating a new player
	 * @param personPower sets the power for a new player
	 * @param personHealth sets the health for a new player
	 */
	public Person(int personPower, int personHealth) {
		this.setPower(personPower);
		this.health = personHealth;
	}
	public Person() {
		this.setPower(50);
		this.health = 100;
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
	public void chooseMove() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What's your move? use <W,A,S,D> keys.");
		while (!sc.hasNext("[WASDwasd]")) {
		    System.out.println("That's not correct, please try again. Use only <W,A,S,D> keys!");
		    sc.next();
		}
		String input = sc.next();

		System.out.println("Moving: " + input);
				
		if (input.equalsIgnoreCase("W")) {
		
		} else if (input.equalsIgnoreCase("A")) {
		
		} else if (input.equalsIgnoreCase("S")) {
		
		} else if (input.equalsIgnoreCase("D")) {
		
		}
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
	public int getPower() {
		return power;
	}
	
	/**
	 * Constructor for the power
	 * @param power takes the integer of the power of the player
	 */
	public void setPower(int power) {
		this.power = power;
	}
	
}
