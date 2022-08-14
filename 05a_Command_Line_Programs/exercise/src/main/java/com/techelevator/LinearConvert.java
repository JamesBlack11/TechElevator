package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

    public static void main(String[] args) {
        int M=0, F=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Length: ");
        int measurement = Integer.parseInt(scanner.nextLine());
        System.out.println("Is the measuremement in (m)eter, or (f)eet? ");
        String measure = scanner.nextLine();
        if (measure.equals("m")) {
            System.out.println(measurement + "m" + " is " + (measurement * 3.2808399 ) + "f");
        } else if (measure.equals("f")) {
            System.out.println(measurement + "f" + " is " + (measurement * 0.3048 ) + "m");
        }

        }
    }





