package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.passenger.PassengerContactFactory;
import za.ac.cput.repository.passenger.PassengerContactRepo;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class PassengerContactRepoTest {

    public static PassengerContactRepo repository = PassengerContactRepo.getRepository();
    private static PassengerContact passengerContact = PassengerContactFactory.CreatePassengerCont("007","009");


    @Test
    void a_create() {
        PassengerContact created = repository.create(passengerContact);
        assertEquals(passengerContact.getPassengerId(), created.getPassengerId());
        System.out.println("Creat: " + created);

    }

    @Test
    void b_read() {
        PassengerContact read = repository.read(passengerContact.getPassengerId());
        assertNotNull(read);
        System.out.println("Read : "+read);
    }

    @Test
    void c_update() {
        PassengerContact updated = new PassengerContact.Builder().copy(passengerContact).setConId("+4782228282")
                .build() ;
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(passengerContact.getPassengerId());
        assertTrue(success);
        System.out.println("Deleted : " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all : ");
        System.out.println(repository.getAll());
    }
}