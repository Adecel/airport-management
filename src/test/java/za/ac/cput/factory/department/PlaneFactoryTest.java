package za.ac.cput.factory.department;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Plane;

import static org.junit.jupiter.api.Assertions.*;

class PlaneFactoryTest {

    @Test
    void buildWithSuccess(){
        Plane plane =  PlaneFactory.build("99Air87B5","lufthansa",
                "A330 - 7.3 tonnes of cargo", "Airbus A333-300");
        System.out.println(plane);
        assertNotNull(plane);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                PlaneFactory.build(null,"lufthansa",
                        "A330 - 7.3 tonnes of cargo", "Airbus A333-300"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}