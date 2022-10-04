package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void buildWithSuccess() {
        User user_a = UserFactory.build("user01",
                new Name("Adecel", "Rusty", "Mabiala"),
                new Gender("M","Male"));
        String userId = user_a.getId();
        assertEquals("user01", userId);
        System.out.println(user_a);
    }

    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                UserFactory.build(null,
                        new Name("Adecel", "Rusty", "Mabiala"),
                        new Gender("M","Male")));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }

}