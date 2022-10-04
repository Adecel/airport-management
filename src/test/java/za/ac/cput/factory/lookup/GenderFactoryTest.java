package za.ac.cput.factory.lookup;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;

import static org.junit.jupiter.api.Assertions.*;

class GenderFactoryTest {

    @Test
    void buildWithSuccess() {
        Gender gender = GenderFactory.build("M", "Male user");
        System.out.println(gender);
        assertNotNull(gender);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                GenderFactory.build(null, "Male user"));
        String expectedMessage = "Invalid value for param:";
        String actualMessage = exception.getMessage();
        System.out.println(exception.getMessage());
        assertTrue(actualMessage.contains(expectedMessage));

    }

}