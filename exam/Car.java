package exam;

public class Car {
	private String brand, registrationNumber;
	private int modelYear;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber.toUpperCase();
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getModelYear() {
		return modelYear;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
}