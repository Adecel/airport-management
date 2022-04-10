package za.ac.cput.repository.impl;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.AirportManagement;
import za.ac.cput.factory.AirportManagementFactory;
import za.ac.cput.repository.impl.AirportManagementRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AirportManagementRepositoryTest {

    private static AirportManagementRepository repository = AirportManagementRepository.getRepository();
    private static AirportManagement airportManagement = AirportManagementFactory.management("Maya-Maya",
            "Brazzaville", "central of Africa");

    @Test
    void a_create() {
        AirportManagement created = repository.create(airportManagement);
        assertEquals(airportManagement.getAirportName(), created.getAirportName());

        System.out.println("Create : " + created);
    }

    @Test
    void b_read() {
        AirportManagement read = repository.read(airportManagement.getAirportName());
        assertNotNull(read);

        System.out.println("Read : " + read);
    }

    @Test
    void c_update() {
        AirportManagement updated = new AirportManagement.Builder().copy(airportManagement)
                .setAirportName("Cape town international").setCityName("Cape Town")
                .setArea("south of Africa").build();
        assertNotNull(repository.update(updated));

        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(airportManagement.getAirportName());
        assertTrue(success);

        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}