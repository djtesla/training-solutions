package week05.week05d05;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;


    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public Song(String name, long lengthInSeconds, String artist) {

        if (isEmpty(name) || isEmpty(artist)) {
            throw new IllegalArgumentException("name or artist is empty!");
        }
        this.name = name;
        this.artist = artist;

        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException("length must be greater than 0!");
        }
        this.lengthInSeconds = lengthInSeconds;
    }


    public boolean isEmpty(String text) {
        return text == null || text.isBlank();

    }

    public double getLengthInMins () {
        return (double) lengthInSeconds / 60;
    }

    @Override
    public String toString() {
        return artist + " : " + name + " (" + lengthInSeconds + "s)";
    }
}


    /*Mai Senior feladat:
        Készítsünk egy Song osztályt, melynek az alábbi mezői vannak:
        - String name
        - long lengthInSeconds
        - String artist
        A Song konstruktorában ellenőrizzük, hogy a name és az artist üres-e. Dobjunk kivételt, ha igen.
        Ellenőrizzük továbbá a lengthInSeconds-ot is, hogy nagyobb legyen, mint 0!
        Készítsünk egy Playlist osztályt, melynek van egy konstruktora, amiben Song-ok Listáját fogadja el.
        Irjunk egy metódust findByLengthGreaterThan néven, mely egy int-et vár paraméterként mins néven.
        Azoknak a Song-oknak a listáját adjuk vissza, melyek hosszabbak percben (!), mint a Song lengthInSeconds mezője.
        Bónusz feladat 1: írjunk teszteket!
        Bónusz feladat 2: Implementáljuk megfelelően a toString metódust a Song és a Playlist osztályban, hogy a Playliset-
        kiirva a konzolra olvasható eredményt kapjunk! (edited)*/
