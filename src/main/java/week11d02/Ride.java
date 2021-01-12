package week11d02;

public class Ride {

    private int weekDay;
    private int indexOfRide;
    private int rideInKm;

    public Ride(int weekDay, int indexOfRide, int rideInKm) {
        this.weekDay = weekDay;
        this.indexOfRide = indexOfRide;
        this.rideInKm = rideInKm;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public int getIndexOfRide() {
        return indexOfRide;
    }

    public int getRideInKm() {
        return rideInKm;
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
        több ilyen nap is van akkor a korább*/
