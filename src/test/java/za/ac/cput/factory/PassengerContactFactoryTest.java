package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.passenger.PassengerContactFactory;

class PassengerContactFactoryTest {

    @Test
    public void test(){

        PassengerContact passengerContact = new PassengerContactFactory().CreatePassengerCont
                ("002","402");

        System.out.println(passengerContact.toString());
    }
}