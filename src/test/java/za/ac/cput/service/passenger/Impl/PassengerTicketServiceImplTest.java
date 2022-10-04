package za.ac.cput.service.passenger.Impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.factory.passenger.PassengerTicketFactory;
import za.ac.cput.service.passenger.PassengerTicketService;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PassengerTicketServiceImplTest {
    @Autowired
    private PassengerTicketServiceImpl service;

    @Test
    @Order(1)
    void save() {
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
        PassengerTicket savedPassengerTicket = service.save(passengerTicket);
        assertEquals(passengerTicket.getPassengerID(), savedPassengerTicket.getPassengerID());
    }

    @Test
    @Order(2)
    void read() {
        Optional<PassengerTicket> passengerTicket = service.read("100");
        assertFalse(passengerTicket.isPresent());
    }

    @Test
    @Order(3)
    void delete() {
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
        PassengerTicket savedPassengerTicket = service.save(passengerTicket);
        service.delete(savedPassengerTicket.getPassengerID());
        Optional<PassengerTicket> readPassengerTicket = service.read(savedPassengerTicket.getPassengerID());
        assertFalse(readPassengerTicket.isPresent());
    }


    @Test
    @Order(4)
    void findByPassengerID() {
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
        PassengerTicket savedPassengerTicket = service.save(passengerTicket);
        PassengerTicket readPassengerTicket = service.findByPassengerID(savedPassengerTicket.getPassengerID());
        assertEquals(passengerTicket.getPassengerID(), readPassengerTicket.getPassengerID());
    }

    //    @Test
//    @Order(5)
//    void deleteById() {
//        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
//        PassengerTicket savedPassengerTicket = service.save(passengerTicket);
//        service.deleteById(savedPassengerTicket.getPassengerID());
//        Optional<PassengerTicket> readPassengerTicket = service.read(savedPassengerTicket.getPassengerID());
//        assertFalse(readPassengerTicket.isPresent());
//    }
    @Test
    @Order(5)
    void findAll() {
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(1000);
        PassengerTicket savedPassengerTicket = service.save(passengerTicket);
        PassengerTicket passengerTicket2 = PassengerTicketFactory.createPassengerTicket(5000);
        PassengerTicket savedPassengerTicket2 = service.save(passengerTicket2);
        assertEquals(2, service.findAll().size());

    }
}