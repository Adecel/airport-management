package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.user.UserFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;
    private static User user_a =
            UserFactory.build("user01",
                    new Name("Adecel", "Rusty", "Mabiala"),
                    new Gender("M","Male"));

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        User user = userService.save(user_a);
        assertNotNull(user);
    }

    @Test
    @Order(2)
    void read() {
        Optional<User> read = this.userService.read("user01");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("user01", user_a.getId())
        );
    }


    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.userService.delete(user_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.userService.deleteById("user01");
    }

    @Test
    void findAll() {
    }
}