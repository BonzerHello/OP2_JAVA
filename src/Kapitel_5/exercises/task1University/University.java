package Kapitel_5.exercises.task1University;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "university")
@XmlType(propOrder = {"name","staff","students"})
public class University {

	@XmlElement
	private String name;
	@XmlElementWrapper(name = "staff")
	@XmlElement(name="staffmember")
	private List<Person> staff;
	@XmlElementWrapper(name = "student")
	@XmlElement(name="student")
	private List<Student> students;

	public University() {
		name = "unknown";
		staff = new ArrayList<Person>();
		students = new ArrayList<Student>();
	}

	public University(String aName) {
		this();
		name = aName;
	}

	public String getName() {
		return name;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public void addStaff(Person p) {
		staff.add(p);
	}

	public List<Person> getStaff() {
		return staff;
	}

	public List<Student> getStudents() {
		return students;
	}

}
