package Kapitel_3.examples.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * This class reads a text file line by line and 
 * computes the number of lines
 * 
 * The exceptions are handled with try-catch-finally (good example).
 * 
 * @author lua1
 */
public class FileProg_fin1 {
	public static void main(String[] args) {

		int lineNumber = 0;
		FileReader reader;
		try {
			reader = new FileReader("in.txt");

			Scanner in = new Scanner(reader);

			try {
				while (in.hasNextLine()) {
					in.nextLine();

					lineNumber++;
				}
				in.close();
			} finally {
				reader.close();
			}

		} catch (IOException e) {
			System.err.println("An Error occured: " + e.getMessage());
			// e.printStackTrace();
		}

		System.out.println("Anzahl der Zeilen: " + lineNumber);
		System.out.println("Done!");
	}
}
