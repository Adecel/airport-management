package za.ac.cput.repository.impl;

//220169136 Dieuci Djate Nsibu
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.PassengerTicket;
import za.ac.cput.factory.PassengerTicketFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class PassengerTicketRepositoryTest {

    private static PassengerTicketRepository repository = PassengerTicketRepository.getRepository();
    private static PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket("PA123","T01234",1000,"L222");

    @Test
    void a_create() {
        PassengerTicket created = repository.create(passengerTicket);
        assertEquals(passengerTicket.getPassengerID(),created.getPassengerID());
        System.out.println("Create: "+created);
    }

    @Test
    void b_read() {
        PassengerTicket read = repository.read(passengerTicket.getPassengerID());
        assertNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        PassengerTicket updated = new PassengerTicket.Builder().copy(passengerTicket).setPassengerID("PA333")
                .setTicketID("T0245")
                .setPrice(1000)
                .setLuggageID("L222")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean successful = repository.delete(passengerTicket.getPassengerID());
        assertTrue(successful);
        System.out.println("Deleted: "+ successful);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}