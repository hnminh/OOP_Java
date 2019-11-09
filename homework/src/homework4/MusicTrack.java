package homework4;

public class MusicTrack implements Comparable<MusicTrack> {
    private String title, artist;
    private int duration, rating;

    // implements method from Comparable interface
    @Override
    public int compareTo(MusicTrack another){
        return title.compareToIgnoreCase(another.title);
    }

    // constructor
    public MusicTrack(String title, String artist, String duration, int rating){
        this.title = title;
        this.artist = artist;
        this.rating = rating;

        // change duration into seconds
        int temp = 0, result = 0;
        for (int i = 0; i < duration.length(); i++){
            if (duration.charAt(i) == ':'){
                result += temp*60;
                temp = 0;
            } else {
                temp = temp*10 + Integer.parseInt(duration.substring(i, i + 1));
            }
        }
        this.duration = result + temp;  // include the seconds
    }

    public String getDuration(){
        int hour = 0, minute = 0, second = 0;
        int temp = duration;
        second = temp%60;
        temp = temp/60;
        minute = temp%60;
        temp = temp/60;
        hour = temp;
        if (hour > 0) return hour + ":" + minute + ":" + second;
        else if (minute > 0) return minute + ":" + second;
        else return second + "";
    }

    public String getTrackDetails(){
        return "Song: " + title + ", Artist: " + artist + ", Duration: " + getDuration() + ", Rating: " + rating;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getDurationInSecondsFormat(){
        return duration;
    }

    public int getRating(){
        return rating;
    }
}