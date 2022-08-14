package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.lookup.TicketFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class TicketServiceImplTest {
    @Autowired
    private TicketServiceImpl service;

    private static Ticket ticket1 = TicketFactory.createTicket("CAPE TOWN");


    @Test
    void save() {
        System.out.println("Create:"+ticket1);
        Ticket created = service.save(ticket1);
        assertNotNull(created);
        System.out.println("Created:"+created);
    }

    @Test
    void read() {
        Optional<Ticket> read = service.read(ticket1.getTicketID());
        assertEquals(ticket1, read.get());
        System.out.println("Read:"+read);
    }

    @Test
    void delete() {
        Optional<Ticket> read = service.read(ticket1.getTicketID());
        service.delete(read.get());
        Optional<Ticket> deleted = service.read(ticket1.getTicketID());
        assertNull(deleted);
        System.out.println("Deleted:"+deleted);
    }

    @Test
    void findByTicketID() {
        Ticket found = service.FindByTicketID(ticket1.getTicketID());
        assertEquals(found.getTicketID(), ticket1.getTicketID());
        System.out.println("Found:"+found);
    }
}