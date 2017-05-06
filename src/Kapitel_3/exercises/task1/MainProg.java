package Kapitel_3.exercises.task1;

public class MainProg {

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		NIOListOfNumbers list = new NIOListOfNumbers();	
		list.readList("InFile1.txt");
		list.writeList();		
		System.out.println("Done !!");
				
	}

}
