package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.lookup.TicketFactory;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TicketServiceImplTest {
    @Autowired
    private TicketServiceImpl ticketService;
    private static Ticket ticket1 = TicketFactory.createTicket("CAPE TOWN");

    @Test
    void save() {
        Ticket ticket = ticketService.save(ticket1);
        assertNotNull(ticket);
        System.out.println(ticket);
    }

    @Test
    void read() {
        Optional<Ticket> read = ticketService.read("CAPE TOWN");
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void delete() {
        ticketService.delete(ticket1);
    }

    @Test
    void findByTicketID() {
        Ticket ticket = ticketService.FindByTicketID("CAPE TOWN");
        assertNotNull(ticket);
        System.out.println(ticket);
    }
}