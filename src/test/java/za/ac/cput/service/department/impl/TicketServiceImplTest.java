package za.ac.cput.service.department.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Ticket;
import za.ac.cput.factory.department.TicketFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TicketServiceImplTest {

    @Autowired
    private TicketServiceImpl ticketService;
    private static Ticket ticket_a =
            TicketFactory.build("T102","user01", "Addis09667",
                    "F56", "R 1500", "25.00 Kg");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Ticket ticket = ticketService.save(ticket_a);
        assertNotNull(ticket);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Ticket> read = this.ticketService.read("T102");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("T102", ticket_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.ticketService.delete(ticket_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.ticketService.deleteById("T102");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}