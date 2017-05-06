package Kapitel_5.exercises.task1University;


import Kapitel_5.examples.bookstore.BookStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public final class UniMain {

	private UniMain() {
	}

	private static final String UNIVERSITY_XML = "university.xml";

	public static void main(String[] args)  {

		// create some persons 
		Student student = new Student("Max", "max@bfh.ch", "B");
		Student student2 = new Student("Tom", "tom@bfh.ch", "c");
		Professor prof = new Professor("Mr. X", "prof.x@bfh.ch", "IT Security");
		Employee empl = new Employee("Erni Schmidt", "erni.schmidt@bfh.ch",
				"HR");

		// create uni, assigning staff and students
		University bfh = new University("bfh");

		bfh.addStaff(student);
		bfh.addStaff(prof);
		bfh.addStaff(empl);

		bfh.addStudent(student);
		bfh.addStudent(student2);

		// create JAXB context and instantiate marshaller
		try {
			JAXBContext context = JAXBContext.newInstance(University.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write to System.out
			m.marshal(bfh, System.out);

			// Write to File
			m.marshal(bfh, new File("university.xml"));
		}catch(Exception e){

		}
	}
}
