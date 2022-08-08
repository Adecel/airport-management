package za.ac.cput.factory.passenger;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.passenger.Passengers;
import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class PassengersFactoryTest {
    @Test
    void buildWithSuccess(){
        Passengers passengers =  PassengersFactory.createPassengers("425156626", "Andrew", "Kissimba", "24");
        System.out.println(passengers);
        assertNotNull(passengers);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PassengersFactory
                        .createPassengers("", "Andrew", "Kissimba", "24"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("PassengerID"));
    }

}

