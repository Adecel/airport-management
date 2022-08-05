package za.ac.cput.repository.impl;


//220169136 Dieuci Djate Nsibu
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.repository.department.FlightRepository;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class FlightRepositoryTest {
    private static FlightRepository repository = FlightRepository.getRepository();
    private static Flight flight = FlightFactory.createFlight("FA123","100","20:00","23:45");

    @Test
    void a_create() {
        Flight created = repository.create(flight);
        assertEquals(flight.getFlightID(),created.getFlightID());
        System.out.println("Create: "+created);
    }

    @Test
    void b_read() {
        Flight read = repository.read(flight.getFlightID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Flight updated = new Flight.Builder().copy(flight).setFlightID("FA123")
                .setDepartureTime("20:00")
                .setArrivalTime("23:15")
                .setCapacity("100")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(flight.getFlightID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}