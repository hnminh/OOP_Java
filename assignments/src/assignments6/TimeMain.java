package assignments6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeMain {
    public static void main(String[] args) {
        List<Time> dates = new ArrayList<>();
        dates.add(new Time());
        dates.add(new Time(12, 3, 2015));
        dates.add(new Time(30, 3, 2018));
        dates.add(new Time(23, 4, 2018));
        dates.add(new Time(1, 1, 2019));
        dates.add(new Time(1, 1, 2019));
        dates.add(new Time(5, 12, 2020));

        Collections.sort(dates, new TimeComparator());
        
        for (int i = 0; i < dates.size(); i++)
            System.out.println(dates.get(i).getTime());
    }
}