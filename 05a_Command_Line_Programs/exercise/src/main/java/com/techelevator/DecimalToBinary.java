package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner binary = new Scanner(System.in);

        //"toBinaryString(i)) found online at https://www.tutorialspoint.com/java/lang/integer_tobinarystring.htm Citing my source//
        System.out.print("Please enter in a series of decimal values (separated by spaces):  ");
        String decimals = binary.nextLine();
        String[] decimalBinary = decimals.split(" ");
        for (int i = 0; i < decimalBinary.length; i++) {
            int binaryNum = Integer.parseInt(decimalBinary[i]);


            System.out.println(decimalBinary[i] + " in binary is " + Integer.toBinaryString(binaryNum));


        }
    }
}


