package Kapitel_5.examples.classesFromXsd;

import Kapitel_5.examples.classesFromXsd.ch.bfh.persons.PersonType;
import Kapitel_5.examples.classesFromXsd.ch.bfh.persons.PersonsType;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;



public final class UnMarshallPersons {
	
	private final static String PACKAGE = "ch.bfh.persons";
	private final static String XSD_FILE = "schema/persons.xsd";
	private final static String XML_FILE = "personsCreated.xml";

	public static void main(String[] l){
		// First of all: Validate the  XML file against it's schema
		if (!XMLValidation.validateXMLSchema(XSD_FILE, XML_FILE)) {
			System.out.println("THE XML file " +
                                          XML_FILE+ " is not valid against " + XSD_FILE);
			System.exit(0);
		}
		else
			System.out.println("THE XML file " +
                                          XML_FILE+ " is valid against " + XSD_FILE);

		try {
			// Get the context with out a specific class !!!
			JAXBContext context = JAXBContext.newInstance(PACKAGE);
			
			// Get an unmarshaller object from the context
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// Define a source (=our XML file)
			Source source = new StreamSource(new java.io.FileInputStream(XML_FILE));
			
			// UnMarshall the XML content and get access to the root element
			JAXBElement<PersonsType> root =
                            unmarshaller.unmarshal(source,PersonsType.class);
			
			// Our root element can deliver a persons object (of type PersonsType)
			PersonsType pesons = root.getValue();
			
			// The persons object delivers a list of PersonType objects
			List<PersonType> personsList = pesons.getPerson();
			// These are real java objects and you can work with them
			
			// Display them
			for(PersonType p: personsList) System.out.println(p.getFirstName());
		}
		catch (JAXBException e) {e.printStackTrace();}
		catch (FileNotFoundException e) {e.printStackTrace();}
	}
}

