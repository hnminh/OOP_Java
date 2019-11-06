package assignments6;

import java.util.Comparator;

public class TimeComparator implements Comparator<Time> {
    @Override
    public int compare(Time t1, Time t2){
        // compare year
        if (t1.getYear() > t2.getYear()) return 1;
        else if (t1.getYear() < t2.getYear()) return -1;
        else {  // compare month
            if (t1.getMonth() > t2.getMonth()) return 1;
            else if (t1.getMonth() < t2.getMonth()) return -1;
            else {  // compare day
                if (t1.getDay() > t2.getDay()) return 1;
                else if (t1.getDay() < t2.getDay()) return -1;
                else return 0;
            }
        }
    }
}