package Pruefung_1.ZZ_Aufgaben.Task5;

import javax.xml.bind.annotation.*;

@XmlSeeAlso({DieselCar.class,ElectricCar.class,GasolineCar.class})
@XmlType(propOrder = {"license_number","model","performance"})
@XmlAccessorType(XmlAccessType.FIELD)
abstract public class Car {


	private String model;
	@XmlElement(name = "license")
	private String license_number;

	private double performance;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
		public String getLicense_number() {
		return license_number;
	}
	
	public double getPerformance() {
		return performance;
	}
		public void setPerformance(double performance) {
		this.performance = performance;
	}
	
}
