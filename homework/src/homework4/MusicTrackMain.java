package homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MusicTrackMain {
    public static void main(String[] args) {
        List<MusicTrack> tracks = new ArrayList<>();
        tracks.add(new MusicTrack("Hieu Ung Tron Chay", "Ca Hoi Hoang", "4:20", 5));
        tracks.add(new MusicTrack("Ha Noi O Sai Gon", "Trang", "3:54", 3));
        tracks.add(new MusicTrack("Phut Ban Dau", "Vu.", "4:03", 5));
        tracks.add(new MusicTrack("Mau", "Ngot", "3:37", 5));
        tracks.add(new MusicTrack("Dong Kiem Em", "Vu.", "4:06", 2));
        tracks.add(new MusicTrack("Lemon Boy", "Cavetown", "4:33", 4));
        tracks.add(new MusicTrack("Lan Cuoi", "Ngot", "3:43", 5));
        tracks.add(new MusicTrack("Chuyen Kenh", "Ngot", "4:34", 5));
        tracks.add(new MusicTrack("Talk To Me", "Cavetown", "4:37", 5));
        tracks.add(new MusicTrack("Co Ay", "Ca Hoi Hoang", "4:16", 5));

        System.out.println("SORT BY TITLE");
        Collections.sort(tracks);
        for (int i = 0; i < tracks.size(); i++)
            System.out.println(tracks.get(i).getTrackDetails());

        System.out.println();
        System.out.println("SORT BY RATING");
        Collections.sort(tracks, new TracksComparator());
        for (int i = 0; i < tracks.size(); i++)
            System.out.println(tracks.get(i).getTrackDetails());

        System.out.println();
        System.out.println("SORT BY ARTIST");
        tracks.sort((s1, s2) -> s1.getArtist().compareTo(s2.getArtist()));
        for (int i = 0; i < tracks.size(); i++)
            System.out.println(tracks.get(i).getTrackDetails());

        System.out.println();
        System.out.println("SORT TRACKS FROM \"NGOT\" BY DURATION");
        List<MusicTrack> choseArtistTracks = tracks.stream()
            .sorted(Comparator.comparing(MusicTrack::getDurationInSecondsFormat))
            .filter(o -> o.getArtist().equals("Ngot"))
            .collect(Collectors.toList());
        for (int i = 0; i < choseArtistTracks.size(); i++)
            System.out.println(choseArtistTracks.get(i).getTrackDetails());
    }
}