package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void buildWithSuccess() {
        Name name = NameFactory.build("Adecel", "Rusty", "Mabiala");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    void buildWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                NameFactory.build(null, "Rusty", ""));
        String expectedMessage = "Invalid value for param:";
        String actualMessage = exception.getMessage();
        System.out.println(exception.getMessage());
        assertTrue(actualMessage.contains(expectedMessage));

    }
}