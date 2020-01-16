package project_1;

public class Consumption {
	
	private String deviceName, dateUsed;
	private double timeUsed, consumptionUnit;
	
	public Consumption(String deviceName, double timeUsed, String dateUsed, double consumptionUnit) {
		this.deviceName = deviceName;
		this.timeUsed = timeUsed;
		this.dateUsed = dateUsed;
		this.consumptionUnit = consumptionUnit;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public double getTimeUsed() {
		return timeUsed;
	}
	
	public String getDateUsed() {
		return dateUsed;
	}
	
	public double getConsumption() {
		return consumptionUnit*timeUsed;
	}
}
