package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.PassengerContact;

import static org.junit.jupiter.api.Assertions.*;

class PassengerContactFactoryTest {

    @Test
    public void test(){

        PassengerContact passengerContact = new PassengerContactFactory().CreatePassengerCont
                ("002","402");

        System.out.println(passengerContact.toString());
    }
}