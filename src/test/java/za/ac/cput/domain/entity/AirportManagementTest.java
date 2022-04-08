package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportManagementTest {
    @Test
    public void test() {
        AirportManagement airportM = new AirportManagement.Builder().setAirportName("MayaMaya")
                .setCityName("Brazzaville").setArea("Center of Africa").build();

        System.out.println(airportM);
    }
}