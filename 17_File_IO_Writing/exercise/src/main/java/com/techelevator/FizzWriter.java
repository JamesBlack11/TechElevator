package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Pick a destination for this file >>>");
		String fileDestination = userInput.nextLine();
		File fizzBuzz = new File (fileDestination);
		String fizzBuzzWriter = "";

		try (PrintWriter writer = new PrintWriter(fizzBuzz); ) {
			for (int i = 1; i < 301 ; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					writer.println("FizzBuzz");
				} else if (i % 3 == 0) {
					writer.println("Fizz");
				} else if (i % 5 == 0) {
					writer.println("Buzz");
				} else {
					writer.println(i);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("This destination is invalid");
			System.exit(1);
		}

	}
	}