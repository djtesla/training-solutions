package week13d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitiesTest {

    @Test

    public void getLongestCityNameTest() {

        String city =new Cities().getLongestCityName("iranyitoszamok-varosok-2021.csv");

        System.out.println(city);
    }

}