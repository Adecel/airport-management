package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.lookup.TicketFactory;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceImplTest {

    @Autowired
    private TicketServiceImpl ticketService;

    @Test
    @Order(1)
    void save() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        assertEquals(ticket.getTicketID(), savedTicket.getTicketID());
    }

    @Test
    @Order(2)
    void read() {
        Optional<Ticket> ticket = ticketService.read("Cape Town");
        assertFalse(ticket.isPresent());
    }

    @Test
    @Order(3)
    void delete() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        ticketService.delete(savedTicket.getTicketID());
        Optional<Ticket> readTicket = ticketService.read(savedTicket.getTicketID());
        assertFalse(readTicket.isPresent());
    }

    @Test
    @Order(4)
    void findByTicketID() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        Ticket readTicket = ticketService.findByTicketID(savedTicket.getTicketID());
        assertEquals(ticket.getTicketID(), readTicket.getTicketID());
    }

    @Test
    @Order(5)
    void findAll() {
        Ticket ticket = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket = ticketService.save(ticket);
        Ticket ticket2 = TicketFactory.createTicket("Cape Town");
        Ticket savedTicket2 = ticketService.save(ticket2);
        assertEquals(2, ticketService.findAll().size());
    }
}