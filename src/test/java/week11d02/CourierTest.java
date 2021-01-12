package week11d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    public void addRideTest() {

        Courier courier = new Courier();

        courier.addRide(new Ride(1,1,30));

        assertEquals(1, courier.getRides().size());


        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1,1,30)));

        courier.addRide(new Ride(3,3,30));

        assertEquals(2, courier.getRides().size());

        assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1,4,30)));

        assertEquals(2, courier.getDayOfNoWork());


    }




}