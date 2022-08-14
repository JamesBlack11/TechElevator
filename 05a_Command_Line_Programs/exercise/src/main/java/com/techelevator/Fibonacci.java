package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		{
			int number1 = 0;
			int number2 = 1;
			int number3;
			int i;
			int expanse = number1 + number2;
			Scanner sc = new Scanner(System.in);

			System.out.println("Please enter a number: ");

			int fibonacci = Integer.parseInt(sc.nextLine());

			System.out.print(number1 + " , " + number2);

			while ((number1 + number2 ) <= fibonacci) {
				number3 = number1 + number2;

				number1 = number2;
				number2 = number3;


				System.out.print(" , " + number3);
			}
		}
	}
}