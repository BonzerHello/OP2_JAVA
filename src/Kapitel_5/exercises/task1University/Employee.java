package Kapitel_5.exercises.task1University;

import javax.xml.bind.annotation.XmlElement;

public class Employee extends Person {

	@XmlElement
	private String department;



	public Employee() {
		super();
		this.department = "unknown";
	}

	public Employee(String aName, String anEmail, String aDepartment) {
		super(aName, anEmail);
		department = aDepartment;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getDescription() {
		return "Works in " + this.department;
	}

}
