package assignments1;

public class Student {
	private String name;
	public double grade1, grade2;
	
	public double average() {
		return (grade1 + grade2)/2;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
