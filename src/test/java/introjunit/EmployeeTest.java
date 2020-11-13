package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void testCreate () {

        //Given
        Employee employee = new Employee("John", 22);

        //When
        String resultName = employee.getName();

        //Then
        assertEquals("John", resultName);


    }

    @Test
    public void testHaveBirtDay() {

        //Given
        Employee employee = new Employee("John", 23);

        //When
        employee.haveBirthday();

        //Then
        assertEquals(24, employee.getAge());


    }

}