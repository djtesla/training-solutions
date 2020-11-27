package week05.week05d05;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private List<Song> songs;


    public PlayList(List<Song> songs) {
        this.songs = songs;
    }


    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return songs.toString();
    }

    public List<Song> findByLengthGreaterThan(int mins) {

        List<Song> selectedSongs = new ArrayList<>();

        for (Song song : songs) {
            if (song.getLengthInMins() > mins) {
                selectedSongs.add(song);
            }
        }
        return selectedSongs;
    }
}



     /*   Irjunk egy metódust findByLengthGreaterThan néven, mely egy int-et vár paraméterként mins néven.
        Azoknak a Song-oknak a listáját adjuk vissza, melyek hosszabbak percben (!), mint a Song lengthInSeconds mezője.
        Bónusz feladat 1: írjunk teszteket!
        Bónusz feladat 2: Implementáljuk megfelelően a toString metódust a Song és a Playlist osztályban, hogy a Playliset-
        kiirva a konzolra olvasható eredményt kapjunk! (edited)*/
