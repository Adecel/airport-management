package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.AirportManagement;

import static org.junit.jupiter.api.Assertions.*;

class AirportManagementFactoryTest {

    @Test
    public void test() {
        AirportManagement airportManagement = AirportManagementFactory.management("Maya-Maya",
                "Brazzaville",
                "central of Africa");
        assertNotNull(airportManagement);

        System.out.println(airportManagement);
    }
}