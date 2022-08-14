package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word? >>>");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word? >>>");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file? >>>");
        String sourceFile = userInput.nextLine();
        System.out.println("What is the destination file? >>>");
        String fileDestination = userInput.nextLine();
        File outputFile = new File (fileDestination);
        File inputFile = new File(sourceFile);




        try (Scanner dataInput = new Scanner (inputFile);
                PrintWriter dataOutput = new PrintWriter(outputFile)) {
            while(dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replace(searchWord, replacementWord));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot open the file for writing.");
        }
    }
}