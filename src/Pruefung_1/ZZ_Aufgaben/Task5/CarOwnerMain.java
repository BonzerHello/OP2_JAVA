package Pruefung_1.ZZ_Aufgaben.Task5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public final class CarOwnerMain {

	private CarOwnerMain() {
	}


	public static void main(String[] args) throws JAXBException, IOException {

		ArrayList<Car> carList = new ArrayList<Car>();

		ElectricCar c1 = new ElectricCar();
		c1.setModel("Electric Car 1");
		c1.setLicense_number("GR 89367");
		c1.setLevel(1);
		c1.setPerformance(235.6);
		carList.add(c1);

		DieselCar d2 = new DieselCar();
		d2.setModel("Renault Van V8");
		d2.setLicense_number("NE 23454");
		d2.setPerformance(300);
		d2.setDpm(189);
		carList.add(d2);

		GasolineCar g1 = new GasolineCar();
		g1.setModel("VW Polo");
		g1.setLicense_number("BE 345796");
		g1.setPerformance(234);
		carList.add(g1);
		
		
		CarOwner fred = new CarOwner();
		fred.setFirst_name("Fred");
		fred.setLast_name("Fredkowski");
		fred.setAddress("Bern, Waldbachstrasse 90");
		fred.setCarList(carList);
		
		
		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(CarOwner.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(fred, new File("cars.xml"));
		
	}
}
