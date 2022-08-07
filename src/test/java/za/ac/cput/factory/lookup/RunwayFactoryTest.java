package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.factory.lookup.RunwayFactory;

import static org.junit.jupiter.api.Assertions.*;
//219383448 KISSIMBA NYEMBO ISAAC

class RunwayFactoryTest {
    @Test
    void buildWithSuccess(){
        RunWay runWay =  RunwayFactory.createRunway("A35", "Lufthansa", "Empty");
        System.out.println(runWay);
        assertNotNull(runWay);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                RunwayFactory
                        .createRunway("", "A35", "Empty"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("runwayNumber"));
    }

}