package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.passenger.PassengersFactory;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class PassengersFactoryTest {
    @Test
    public void test(){
        Passengers passengers= PassengersFactory.createPassengers("219383664","JONATHAN","KUMINGA", "20");
        System.out.println(passengers.toString());
        assertNotNull(passengers);
    }


}