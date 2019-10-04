package assignments4;

public class Date {
	
	private int day, month, year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String getDate() {
		return day + "." + month + "." + year;
	}
}
