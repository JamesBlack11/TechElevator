package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {

			Scanner scanner = new Scanner(System.in);

			int lineNumber = 0;

			System.out.print("Please enter path to input file >>> ");
			String path = scanner.nextLine();

			File inputFile = new File(path);

			System.out.print("Enter The Word Search Term >>> ");
			String searchTerm = scanner.nextLine();


			System.out.println("Do you want the search be case sensitive? (Y or N) >>>");
			String yesOrNo = scanner.nextLine();

			scanner.close();

			Scanner wordSearch = new Scanner(inputFile);


			if (Objects.equals(yesOrNo, "Y")) {

				while (wordSearch.hasNextLine()) {
					String line = wordSearch.nextLine();
					lineNumber++;

					if (line.contains(searchTerm)) {
						System.out.print(lineNumber + " ");
						System.out.println(line);
					}
				} wordSearch.close();
			}

			else if (Objects.equals(yesOrNo, "N")) {

				while (wordSearch.hasNextLine()) {
					String line = wordSearch.nextLine();
					lineNumber++;

					if (line.toLowerCase().contains(searchTerm.toLowerCase())) {

						System.out.print(lineNumber + " ");
						System.out.println(line);
					} else if (line.toUpperCase().contains(searchTerm.toUpperCase())) {

						System.out.print(lineNumber + " ");
						System.out.println(line);
					}
				}

				wordSearch.close();
			}
			else System.out.println(yesOrNo + " is not a valid input (Y/N)");
		}
	private static File getSearchFile(String filePath) throws IOException {
		File searchFile = new File(filePath);

		if (!searchFile.exists()) {
			throw new FileNotFoundException("Search file: " + filePath + " does not exist.");
		}

		if (!searchFile.isFile()) {
			throw new IOException("Search file: " + filePath + " exists but is not a file.");
		}

		return searchFile;
	}
	}
