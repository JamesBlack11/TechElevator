package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		double F, C;
		Scanner scanner =new Scanner(System.in);
		System.out.println("Please Enter the Temperature: ");
		int temperature = Integer.parseInt(scanner.nextLine());

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String temp = scanner.nextLine();
		if (temp.equals("C")) {
			System.out.println(temperature + " C is " + ((temperature * 1.8) + 32) + " F.");
		} else if (temp.equals("F")) {
			System.out.println(temperature + " F is " + ((temperature - 32) / 1.8) + " C.");
		}


		   {

		}


		}
	}




