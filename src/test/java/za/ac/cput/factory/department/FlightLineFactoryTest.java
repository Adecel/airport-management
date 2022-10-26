package za.ac.cput.factory.department;
/*
  Dieuci Djate Nsibu
  220169136
  */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.FlightLine;

import static org.junit.jupiter.api.Assertions.*;

class FlightLineFactoryTest {

    @Test
    void buildWithSuccess(){
        FlightLine flightLine =  FlightLineFactory.build(2,"Cape Town - Paris, via Addis ",
                "Cape Town : 15:25 - 2022/09/31");
        System.out.println(flightLine);
        assertNotNull(flightLine);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                FlightLineFactory.build(0,"Cape Town - Paris, via Addis ",
                        "Cape Town : 15:25 - 2022/09/31"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}