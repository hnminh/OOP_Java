package assignments3;

public class ArrayListCollection {
    private int day, month, year;

    public ArrayListCollection(String st) {
        day = Integer.parseInt(st.substring(0, 2));
        month = Integer.parseInt(st.substring(3, 5));
        year = Integer.parseInt(st.substring(6, 10));
        //recentDate = toString();
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
        return getDay() + "." + getMonth() + "." + getYear();
    }

    public boolean equals(ArrayListCollection t) {
        return (day == t.day) && (month == t.month) && (year == t.year);
    }
}