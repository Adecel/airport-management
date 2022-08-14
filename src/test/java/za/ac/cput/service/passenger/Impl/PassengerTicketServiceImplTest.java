package za.ac.cput.service.passenger.Impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.factory.passenger.PassengerTicketFactory;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassengerTicketServiceImplTest {
    @Autowired
    private PassengerTicketServiceImpl service;
    private static PassengerTicket passengerTicket1 = PassengerTicketFactory.createPassengerTicket( 100);

    @Test
    void save() {
        System.out.println("Create:"+passengerTicket1);
        PassengerTicket created = service.save(passengerTicket1);
        assertNotNull(created);
        System.out.println("Created:"+created);
    }

    @Test
    void read() {
        Optional<PassengerTicket> read = service.read(passengerTicket1.getTicketID());
        assertEquals(passengerTicket1, read.get());
        System.out.println("Read:"+read);
    }

    @Test
    void delete() {
        Optional<PassengerTicket> read = service.read(passengerTicket1.getTicketID());
        service.delete(read.get());
        Optional<PassengerTicket> deleted = service.read(passengerTicket1.getTicketID());
        assertNull(deleted);
        System.out.println("Deleted:"+deleted);
    }

    @Test
    void findByTicketID() {
        PassengerTicket found = service.FindByTicketID(passengerTicket1.getTicketID());
        assertEquals(found.getTicketID(), passengerTicket1.getTicketID());
        System.out.println("Found:"+found);
    }
}