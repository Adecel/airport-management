package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.entity.Luggage;
import za.ac.cput.factory.LuggageFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class LuggageRepositoryTest {
    public static LuggageRepository repository =LuggageRepository.getRepository();
    public static Luggage luggage = LuggageFactory.createLuggage("AC243","08", "Founitures");

    @Test
    void a_create() {
        Luggage created = repository.create(luggage);
        assertEquals(luggage.getLuggageID(), created.getLuggageID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Luggage read = repository.read(luggage.getLuggageID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Luggage updated = new Luggage.Builder().copy(luggage).setLuggageID("GD345")
                .setLuggageNumber("05")
                .setLuggageType("Clothing")
                .build();
        assertNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(luggage.getLuggageID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}