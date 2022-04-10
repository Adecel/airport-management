package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.RunWay;
import za.ac.cput.factory.RunwayFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class RunwayRepositoryTest {
    public static RunwayRepository repository =RunwayRepository.getRepository();
    public static RunWay runWay = RunwayFactory.createRunway("6", "Mango", "Empty");



    @Test
    void a_create() {
        RunWay created = repository.create(runWay);
        assertEquals(runWay.getRunwayNumber(), created.getRunwayNumber());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        RunWay read = repository.read(runWay.getRunwayNumber());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        RunWay updated = new RunWay.Builder().copy(runWay).setRunwayNumber("02")
                .setFlightName("Congo Airways")
                .setRunwayStatus("Occupied")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(runWay.getRunwayNumber());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }


}