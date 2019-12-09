package assignment8_2;

import java.time.LocalDate;

public class Date {
	
	private int day, month, year;
	
	public Date() {
		java.time.LocalDate today = LocalDate.now();
        this.day = today.getDayOfMonth();
        this.month = today.getMonthValue();
        this.year = today.getYear();
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getDate() {
		return day + "." + month + "." + year;
	}
}
