package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}


	public String eat() {
		return "chicken feed... ";
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}