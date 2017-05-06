package Kapitel_5.examples.bookstore;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	@XmlAttribute
	private String street;
	private String city;
	
	public Address() {
		street ="unknown";
		city ="unknown";
	}
	
	public Address(String aStreet, String aCity) {
		street = aStreet;
		city = aCity;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

}
