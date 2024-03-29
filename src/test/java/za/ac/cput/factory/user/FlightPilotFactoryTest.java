package za.ac.cput.factory.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.factory.user.FlightPilotFactory;

import static org.junit.jupiter.api.Assertions.*;

class FlightPilotFactoryTest {

    @Test
    void buildWithSuccess(){
        FlightPilot flightPilot =  FlightPilotFactory.build("Pi5","AA13Bus00",
                "user01", "18:25 - 2022/09/30");
        System.out.println(flightPilot);
        assertNotNull(flightPilot);
    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                FlightPilotFactory.build(null,"AA13Bus00",
                        "user01", "18:25 - 2022/09/30"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}