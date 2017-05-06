package Pruefung_1.ZZ_Aufgaben.Task5;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
@XmlRootElement(name = "owner")
@XmlType(propOrder = {"first_name","last_name","address","carList"})
public class CarOwner {


	private String first_name;

	private String last_name;

	private String address;
	@XmlElementWrapper(name="cars")
	@XmlElement(name = "car")
	private ArrayList<Car> carList;
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setCarList(ArrayList<Car> carList) {
		this.carList = carList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}

