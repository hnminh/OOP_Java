package homework4;

import java.util.Comparator;

public class TracksComparator implements Comparator<MusicTrack> {
    @Override
    public int compare(MusicTrack s1, MusicTrack s2){
        if (s1.getRating() > s2.getRating()) return -1;
        else if (s1.getRating() < s2.getRating()) return 1;
        else return 0;
    }
}