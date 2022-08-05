package za.ac.cput.repository.impl;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.passenger.PassengersFactory;
import za.ac.cput.repository.passenger.PassengersRepository;

@TestMethodOrder(MethodOrderer.MethodName.class)

class PassengersRepositoryTest {

    public static PassengersRepository repository =PassengersRepository.getRepository();
    public static Passengers passengers = PassengersFactory.createPassengers("219383664","JONATHAN", "KUMINGA", "20");

    @Test
    void a_create() {
        Passengers created = repository.create(passengers);
        assertEquals(passengers.getPassengerID(), created.getPassengerID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Passengers read = repository.read(passengers.getPassengerID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Passengers updated = new Passengers.Builder().copy(passengers).setPassengerID("219889552")
                .setPassengerFirstName("ISAAC")
                .setPassengerLastName("kISSIMBA")
                .setPassengerAge("24")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(passengers.getPassengerID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}