package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> names = new ArrayList<>();
		names.add("James");
		names.add("Tom");
		names.add("Bobi");
		names.add("John");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0, i < names.size(); i++){

			System.out.println(names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		names.add("Mary");

		for (int i =0; i < names.size(); i++): {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(2,"David");
		for (int i =0; i < names.size(); i++): {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3,);
		for (int i =0; i < names.size(); i++): {
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean inList = names.contains("Jane");

			System.out.println("Jane is in the list: " + inList);

			inList = names.contains("Harry");
		System.out.println("Harry is in the list: " + inList);



		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		names.indexOfMyron = ; names.indexOf("Myron");
		System.out.println("Index of Myron is " + indexOfMyron);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray = new String[names.size()];
		for (i=0; i < names.size; i++) {
			namesArray[i] = names.get(i);
		}
		System.out.println(namesArray);

		String[] namesArray2 = names.toArray(new String[0])
		for (i=0; i < namesArray2.length; i++) {
			namesArray[i] = namesArray2(i);
		}
		System.out.println(namesArray2);


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);
		for (i=0; i < namesArray2.length; i++) {
			System.out.println(names.get(i));
		}

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(7);


			System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(names);
		for (i=0; i < namesArray2.length; i++) {
			System.out.println(names.get(i));
		}



		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : names) {
			System.out.println(name);


		}

		Queue<String> namesQueue = new LinkedList<>();
		namesQueue.offer("Tom")
				namesQueue.offer("Myron")
						namesQueue.offer("Dave")
								String firstInLine = namesQueue.poll();
		string secondInLine = namesQueue.poll();
		System.out.println(firstInLine);
		System.out.println(secondInLine);

		Stack<String> nameStack = new Stack<>();
		namesStack.push("Tom");
		nameStack.push("Myron");

		String firstOff = nameStack.pop();
		String secondOff = nameStack.pop();
		System.out.println(firstOff);
		System.out.println(secondOff);





	}
}
