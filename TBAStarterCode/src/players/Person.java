package players;

import java.util.Scanner;

public class Person {
	
	private String name;
	private int power;
	private int health;
	private int posX, posY;
	
	public Person(int personPower, int personHealth) {
		this.setPower(personPower);
		this.health = personHealth;
	}
	public Person() {
		this.setPower(50);
		this.health = 100;
	}
	
	
	
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
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
}
