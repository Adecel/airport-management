package za.ac.cput.repository.impl.lookup;

//220169136 Dieuci Djate Nsibu
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.lookup.TicketFactory;
import za.ac.cput.repository.lookup.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TicketRepositoryTest {
    private static TicketRepository repository = TicketRepository.getRepository();
    private static Ticket ticket = TicketFactory.createTicket("1B321","CAPE TOWN");

    @Test
    void a_create() {
        Ticket created = repository.create(ticket);
        assertEquals(ticket.getTicketID(),created.getTicketID());
        System.out.println("Create: "+created);
    }

    @Test
    void b_read() {
        Ticket read = repository.read(ticket.getTicketID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Ticket updated = new Ticket.Builder().copy(ticket).setTicketID("")
                .setDestination("CAPE TOWN")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(ticket.getTicketID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}