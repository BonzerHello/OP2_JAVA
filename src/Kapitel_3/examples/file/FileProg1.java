package Kapitel_3.examples.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * This class reads a text file line by line and 
 * computes the number of lines
 * 
 * @author lua1
 */

public class FileProg1 {
	public static void main(String[] args) {

		FileReader reader;
		int lineNumber = 0;


		try {
			reader = new FileReader("in.txt");

			Scanner in = new Scanner(reader);

			while (in.hasNextLine()) {
				in.nextLine();

				lineNumber++;
			}

			reader.close();
			in.close();

			System.out.println("Anzahl der Zeilen: " + lineNumber);
			System.out.println("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
