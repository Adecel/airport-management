package za.ac.cput.factory.department;
/*
  Dieuci Djate Nsibu
  220169136
  */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Flight;

import static org.junit.jupiter.api.Assertions.*;

class FlightFactoryTest {

    @Test
    void buildWithSuccess(){
        Flight flight =  FlightFactory.build("AA13Bus00","19:25 - 2022/09/30",
                "15:25 - 2022/09/31",
                "only for business", "Cape Town");
        System.out.println(flight);
        assertNotNull(flight);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                FlightFactory.build(null,"19:25 - 2022/09/30",
                        "15:25 - 2022/09/31",
                        "only for business", "Cape Town"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}