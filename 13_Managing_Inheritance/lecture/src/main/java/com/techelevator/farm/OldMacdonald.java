package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow cow = new Cow();
		Cat cat = new Cat();
		cat.sleep(true);
		cow.sleep(true);
//		FarmAnimal animal = new FarmAnimal("Foo", "Bar");

		List<FarmAnimal> farmAnimalList = new ArrayList<>();
		farmAnimalList.add(new Cow());
		farmAnimalList.add(new Cat());
		farmAnimalList.add(new Chicken());
		farmAnimalList.add(new Pig());

		for (FarmAnimal animal1 : farmAnimalList)
			System.out.println(animal1.eat());




		Singable[] singables =
				new Singable[] {cow, new Chicken(), new Pig(), cat, new Tractor()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}