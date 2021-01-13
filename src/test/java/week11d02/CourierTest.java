package week11d02;

import org.junit.jupiter.api.Test;
import schoolrecords.Student;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier = new Courier();

    @Test
    public void addRideThrowsException1() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 2, 30)));
        assertEquals("First ride on list must be with index 1", ex.getMessage());
    }

    @Test
    public void addRideTest1() {
        courier.addRide(new Ride(1, 1, 30));
        assertEquals(1, courier.getRides().size());

    }


    @Test
    public void addRideThrowsException2() {
        courier.addRide(new Ride(1, 1, 30));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 1, 30)));
        assertEquals("Ride on the same day must be the next in order", ex.getMessage());
    }

    @Test
    public void addRideThrowsException3() {
        courier.addRide(new Ride(1, 1, 30));
        courier.addRide(new Ride(1, 2, 30));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(2, 2, 30)));
        assertEquals("First ride on the day must be with index 1", ex.getMessage());
    }

    @Test
    public void addRideTest3() {
        courier.addRide(new Ride(1, 1, 30));
        courier.addRide(new Ride(1, 2, 30));
        courier.addRide(new Ride(2, 1, 30));
        courier.addRide(new Ride(2, 2, 30));
        courier.addRide(new Ride(4, 1, 30));
        courier.addRide(new Ride(7, 1, 30));
        courier.addRide(new Ride(7, 2, 30));
        courier.addRide(new Ride(7, 3, 30));
        //courier.addRide(new Ride(3, 2, 30));*/
        System.out.println(courier.getRides().size());

    }



}




