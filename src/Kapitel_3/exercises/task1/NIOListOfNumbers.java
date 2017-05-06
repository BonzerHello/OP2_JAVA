package Kapitel_3.exercises.task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NIOListOfNumbers {

	private Vector<Integer> victor;
	private static final int SIZE = 10;

	public NIOListOfNumbers() {
		victor = new Vector<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			victor.addElement(new Integer(i));
	}

	public void writeList() {

		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < victor.size(); i++)
			lines.add("Value at: " + i + " = " + victor.elementAt(i));

		try {
			Files.write(Paths.get("OutFile.txt"), lines);
		} 	catch (InvalidPathException e) {
			System.err.println("Caught InvalidPathException: "
					+ e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: "
					+ e.getMessage());
		}
	
	}

	public void readList(String s) {
		try {
			Path in = Paths.get(s);

			List<String> lines = Files.readAllLines(in);

			for(String line:lines){
				int number = -1;
				number = Integer.parseInt(line);
				System.out.println("Value: "+number);
				victor.addElement(number);


			}
		}
		catch (NumberFormatException e){
			System.err.println("Cast Exception: ");
			throw new NumberFormatException("Not a Number: ");
		}
		catch(IOException e){
			System.err.println("File not found");

		}

	}
}
