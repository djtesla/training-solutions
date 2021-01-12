package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride rideToBeAdded) {

        if (rides.size() == 0) {

            rides.add(rideToBeAdded);
            return;

        }

        if (rideToBeAdded.getWeekDay() < rides.get(rides.size() - 1).getWeekDay()) {
            throw new IllegalArgumentException("Ride to be added was earlier then last ride");
        }

        if (rideToBeAdded.getIndexOfRide() <= rides.get(rides.size() - 1).getIndexOfRide()) {
            throw new IllegalArgumentException("Ride to be added was earlier then last ride");
        }

        rides.add(rideToBeAdded);
    }

    public int getDayOfNoWork() {

        int[] weekdays = new int[7];
        for (Ride ride : rides) {
            weekdays[ride.getWeekDay() - 1] += 1;
        }

        for (int i = 0; i < weekdays.length; i++) {
            if (weekdays[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

}





/*A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.
        A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután
        azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer
        volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály, adatagokkal,
        konstruktorra, getterekkel.  Készítsd el a `Courier` osztályt. Ez fogja a futárt reprezentálni.
        Legyen egy rides listája ami fuvarokat tárol. Legyen egy addRide metódus, ami csak sorrendben enged
        hozzáadni elemeket a listához. Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár,
        de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon
        belül is sorrendben kerüljenek be az adatok. Ha a paraméterül kapott Ride nem felel meg a feltételeknek dobjunk
        `IllegalArgumentException`-t.   Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha
        több ilyen nap is van akkor a korább

        IllegalArgumentException`-t.   Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott.
        Ha több ilyen nap is van akkor a korábbit!
        */
