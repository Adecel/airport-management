package za.ac.cput.factory.lookup;


//220169136
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.lookup.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    public void test(){
        Ticket ticket = TicketFactory.createTicket("A01234","Cape Town");
        assertNotNull(ticket);
        System.out.println(ticket);
    }
}