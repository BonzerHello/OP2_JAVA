package Kapitel_5.exercises.task1University;

import javax.xml.bind.annotation.XmlElement;


public class Student extends Person {

	@XmlElement
	private String grade;

	public Student() {
		super();
	}
	
	public Student(String aName, String anEmail, String aGrade) {
		super(aName,anEmail);
		grade = aGrade;
	}

    public String getDescription() {
		return getName()+" is a "+grade+ " grade student";
	}

	public String getGrade() {
		return grade;
	}
    
    
}
