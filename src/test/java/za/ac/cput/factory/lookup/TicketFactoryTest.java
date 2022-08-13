package za.ac.cput.factory.lookup;


//220169136
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import za.ac.cput.domain.lookup.Ticket;


import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void testWithSuccess(){
        Ticket ticket = TicketFactory.createTicket("cape town");
        assertEquals("cape town", ticket.getDestination());
        System.out.println(ticket);

    }
//    @Test
//    void testWithFailure(){
//        Ticket ticket = TicketFactory.createTicket("");
//        assertNotEquals("cape town", ticket.getDestination());
//        System.out.println(ticket);
//    }

}
