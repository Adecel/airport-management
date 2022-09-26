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

    @Test
    void save() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        assertEquals(ticket.getTicketID(), savedTicket.getTicketID());
    }

    @Test
    void read() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        Optional<Ticket> readTicket = ticketService.read(savedTicket.getTicketID());
        assertEquals(ticket.getTicketID(), readTicket.get().getTicketID());
    }

    @Test
    void delete() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        ticketService.delete(savedTicket.getTicketID());
        Optional<Ticket> readTicket = ticketService.read(savedTicket.getTicketID());
        assertFalse(readTicket.isPresent());
    }

    @Test
    void findByTicketID() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        Ticket readTicket = ticketService.findByTicketID(savedTicket.getTicketID());
        assertEquals(ticket.getTicketID(), readTicket.getTicketID());
    }

    @Test
    void findAll() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        Ticket ticket2 = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket2 = ticketService.save(ticket2);
        assertEquals(ticketService.findAll().size(), 2);
    }
}