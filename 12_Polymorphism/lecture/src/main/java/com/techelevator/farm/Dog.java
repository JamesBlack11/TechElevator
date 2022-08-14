package com.techelevator.farm;

public class Dog extends FarmAnimal{
    private String size;


    public Dog(String size) {
        super(size + "Dog", "Woof!");
        this.size = size;
    }
}
