package za.ac.cput.factory.passenger;


//220169136 DIEUCI DJATE NSIBU
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.factory.passenger.PassengerTicketFactory;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTicketFactoryTest {

    @Test
    public void test(){
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
        assertEquals(100, passengerTicket.getPrice());
        System.out.println(passengerTicket);
    }

}