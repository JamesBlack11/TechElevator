package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		System.out.println("Enter path to file or directory >>>");
//		String path = userInput.nextLine();
//		File file = new File(path);
//
//		if (file.exists()) {
//			System.out.println("Name: " + file.getName());
//			System.out.println("absolute path: " + file.getAbsolutePath());
//			if (file.isDirectory()) {
//				System.out.println("is is a directory");
//			} else if (file.isFile()) {
//				System.out.println("it is a file");
//			}
//			System.out.println("size: " + file.length());
//		} else {
//			System.out.println(file.getAbsolutePath() + " Shit outta luck bud");
//		}


//		System.out.println("Enter path of new Directory >>>");
//		String path = userInput.nextLine();
//		File newDirectory = new File(path);
//
//		if (newDirectory.exists()) {
//			System.out.println("bitch, " + newDirectory.getAbsolutePath() + " it had been here ho");
//			System.exit(1);
//		} else {
//
//			if (newDirectory.mkdir()) {
//				System.out.println("New Directory just got made ho " + newDirectory.getAbsolutePath());
//			} else {
//				System.out.println("punk ass directory aint gettin made");
//				System.exit(305);
//			}
//
//		}

			System.out.println("Enter path of new Directory >>>");
			path = userInput.nextLine();
			File newFile = new File(newDirectory, path);
			try {
				newFile.createNewFile();
				System.out.println("name: " + newFile.getName());
				System.out.println("absolute path: " + newFile.getAbsolutePath());
				System.out.println("size: " + newFile.length());
			} catch (
					IOException ex) {
				System.out.println("shits beat yo " + ex.getMessage());
			}


//		System.out.println("Enter path of new Directory >>>");
//		String path = userInput.nextLine();
//		File file = new File(path);
//
//
//		if (file.delete()) {
//		System.out.println("That bitch dead");
//	} else {
//			System.out.println("the ho stickin around");
//		}

			{
				System.out.println("Enter path of new Directory >>>");
				String path = userInput.nextLine();
				File newFile = new File(path);

				try {
					newFile.createNewFile();
				} catch (IOException ex) {

					System.out.println("Something wrong " + ex.getMessage());
					System.out.println("Enter some message to write to the file");
					String message = userInput.nextLine();
				}

				try (PrintWriter writer = new PrintWriter(newFile)) {
					writer.print(message);
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		try (PrintWriter writer = new PrintWriter(new FileOutputStream(newFile, true))) {
			writer.append(message);
		} catch(IOException ex) {
		System.out.println("Exception: " + ex.getMessage());
	}
	}

