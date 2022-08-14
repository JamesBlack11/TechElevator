package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greeting = "Hello World";
		System.out.println("greeting : " + greeting);

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 * charAt
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		//charAt
		String name = "Yoda";
		char first = name.charAt(0);
		System.out.println(name);
		System.out.println(first);


		//contains
		System.out.println("**** contains ****");
		String hello = "Hello World!";
		System.out.println("hello : " + hello);
		boolean containsHello = hello.contains("Hello");
		System.out.println("containsHello : " + containsHello);
		boolean containsBogus = hello.contains("bogus");
		System.out.println("containsBogus : " + containsBogus);

		//length
		System.out.println("**** length ****");
		String sayingLg = "So say we all";
		int sayingLgLength = sayingLg.length();
		System.out.println(sayingLgLength);


		//substring
		System.out.println("***** substring *****");
		String sayingSb = "They're taking the hobbits to Isengard!";
		int startIndex = 30;
		int endIndex = sayingSb.length();
		String toWhere = sayingSb.substring(startIndex, endIndex);
		System.out.println(toWhere);


		// replace
		System.out.println("**** replace ****");
		String sayingRep = "Captain Pike is on the bridge";
		String anotherSayingRep = sayingRep.replace("Pike", "Kirk");

		System.out.println(sayingRep.replace("Pike", "Kirk"));
		System.out.println(sayingRep);
		System.out.println(anotherSayingRep);



		//  indexOf
		System.out.println("**** indexOf ****");
		String sayingIndexOf = "I am Groot";
		int index = sayingIndexOf.indexOf("Groot"); //5
		System.out.println(index);

		// startsWith
		System.out.println("**** startsWith ****");
		String sayingSw = "Why so Serious";
		if (sayingSw.startsWith("Why")) {
			System.out.println("Because");
		}

		// endsWith
		System.out.println("**** endsWith ****");
		String sayingEw = "Why so Serious";
		if (sayingEw.endsWith("serious")) {
			System.out.println("Because");




        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
