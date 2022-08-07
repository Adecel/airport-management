package za.ac.cput.factory.department;



//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Flight;

import static org.junit.jupiter.api.Assertions.*;

class FlightFactoryTest {
    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
        FlightFactory.flight("","500","13:00","18:00"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("flightID"));
    }

    @Test
    void buildWithSuccess() {
        Flight flight= FlightFactory
                .flight("test-id","500","13:00","18:00");
        System.out.println(flight);
        assertAll(
                () -> assertNotNull(flight),
                 () -> assertNotNull(flight.getFlightID())

        );

    }
}