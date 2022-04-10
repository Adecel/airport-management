package za.ac.cput.factory;


//220169136 DIEUCI DJATE NSIBU
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.PassengerTicket;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTicketFactoryTest {

    @Test
    public void test(){
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket("0B1111","0A2222",1200,"0AB1122");
        assertNotNull(passengerTicket);
        System.out.println(passengerTicket);
    }

}