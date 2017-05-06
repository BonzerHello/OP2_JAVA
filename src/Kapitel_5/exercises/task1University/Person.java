package Kapitel_5.exercises.task1University;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


@XmlSeeAlso({Student.class,Professor.class,Employee.class})
@XmlType(propOrder = {"name","email"})
abstract public class Person {


	@javax.xml.bind.annotation.XmlElement
	private String email;
	@javax.xml.bind.annotation.XmlElement
	private String name;

	public Person() {
		email = "unkown";
		name = "unkown";
	}

	public Person(String aName, String anEmail) {
		email = anEmail;
		name = aName;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return "A person with name: " + name;
	}

}
