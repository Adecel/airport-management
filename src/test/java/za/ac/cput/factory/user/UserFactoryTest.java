package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.user.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void buildWithSuccess() {
        User user = UserFactory.build(10, new Name("John", "Doe", "Smith"), new Gender("M", "unknown"));
        assertNotNull(user);
        assertEquals(10, user.getId());
        assertEquals("John", user.getName().getFirstName());
        assertEquals("Doe", user.getName().getMiddleName());
        assertEquals("Smith", user.getName().getLastName());
        assertEquals("M", user.getGender().getGender());
        assertEquals("unknown", user.getGender().getDescription());
        System.out.println(user);

    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserFactory.build(0, new Name("Adecel", "Rusty", ""), new Gender("M", "unknown")));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));

    }

}