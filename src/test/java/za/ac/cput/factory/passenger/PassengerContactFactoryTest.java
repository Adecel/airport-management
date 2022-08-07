package za.ac.cput.factory.passenger;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.factory.passenger.PassengerContactFactory;

class PassengerContactFactoryTest {

    @Test
    public void TestPassengerContact(){

        PassengerContact passengerContact = new PassengerContactFactory().CreatePassengerCont
                ("002","402");

        System.out.println(passengerContact.toString());
    }
}