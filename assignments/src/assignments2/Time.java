package assignments2;

import java.time.LocalDate;

public class Time {
    private int day, month, year;
    public String recentDate;
    public static final String[] MONTHNAMES = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final String[] monthNamesLowerCase = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};

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

    public String toString() {
        return day + "." + month + "." + year;
    }

    public String getTime() {
        return toString();
    }

    public String getLongTime() {
        if (day == 1 || day == 21 || day == 31) {
            return "the " + day + "st of " + MONTHNAMES[month - 1] + ", " + year;
        } else if (day == 2 || day == 22) {
            return "the " + day + "nd of " + MONTHNAMES[month - 1] + ", " + year;
        } else if (day == 3 || day == 23) {
            return "the " + day + "rd of " + MONTHNAMES[month - 1] + ", " + year;
        } else {
            return "the " + day + "th of " + MONTHNAMES[month - 1] + ", " + year;
        }
    }

    public static int getMonthNumber(String st) {
        st = st.toLowerCase();
        for (int i = 0; i < 12; i++){
            if (st.equals(monthNamesLowerCase[i])) {
                return i + 1;
            }
        }
        return 0;
    }

    public void setDay(int n) {
        day = n;
    }

    public void setMonth(int n) {
        month = n;
    }

    public void setYear(int n) {
        year = n;
    }

    public boolean equals(Time t) {
        return (day == t.day) && (month == t.month) && (year == t.year);
    }
}