package assignments6;

import java.time.LocalDate;

public class Time {
    private int day, month, year;
    public String recentDate;

    public Time() {
        java.time.LocalDate today = LocalDate.now();
        day = today.getDayOfMonth();
        month = today.getMonthValue();
        year = today.getYear();
    }

    public Time(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public Time(String st) {
        day = Integer.parseInt(st.substring(0, 2));
        month = Integer.parseInt(st.substring(3, 5));
        year = Integer.parseInt(st.substring(6, 10));
        recentDate = toString();
    }

    public String getTime() {
        return day + "." + month + "." + year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public boolean equals(Time t) {
        return (day == t.day) && (month == t.month) && (year == t.year);
    }
}