package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Hostess;

import static org.junit.jupiter.api.Assertions.*;

class HostessFactoryTest {

    @Test
    void buildWithSuccess() {
        Hostess hostess = HostessFactory.build(1,
                new Name("Jeanne", "Doe", "Smith"), new Gender("F", "ss"), "021 123 4567");
        assertNotNull(hostess);
        assertEquals(1, hostess.getId());
        assertEquals("Jeanne", hostess.getName().getFirstName());
        assertEquals("Doe", hostess.getName().getMiddleName());
        assertEquals("Smith", hostess.getName().getLastName());
        assertEquals("F", hostess.getGender().getGender());
        assertEquals("ss", hostess.getGender().getDescription());
        assertEquals("021 123 4567", hostess.getPhoneNumber());
        System.out.println(hostess);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                HostessFactory.build(40,
                        new Name("Maria", "Ruberwa", ""),
                        new Gender("F", "Help to get people in the plan"), "0603662785"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}