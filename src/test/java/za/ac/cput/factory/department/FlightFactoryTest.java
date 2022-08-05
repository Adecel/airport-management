package za.ac.cput.factory.department;


//220169136 DIEUCI DJATE NSIBU
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.department.FlightFactory;


import static org.junit.jupiter.api.Assertions.*;

class FlightFactoryTest {
    @Test
    public void test(){
        Flight flight = FlightFactory.createFlight("0B000","500","10:00","12:00");
        assertNotNull(flight);
        System.out.println(flight);
    }

}