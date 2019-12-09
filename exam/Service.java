package exam;

public class Service extends Item {
	
	private double rate, time;
	
	public Service(String name, double rate, double time) {
		super(name);
		this.rate = rate;
		this.time = time;
	}
	
	public double finalPrice() {
		return rate*time;
	}
	
	public String toString() {
		return "name: " + super.getName() + ", rate: " + rate + ", time: " + time;
	}
}
