package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.factory.user.UserTypeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserTypeServiceImplTest {

    @Autowired
    private UserTypeServiceImpl userTypeService;
    private static UserType userType_a =
            UserTypeFactory.build("user01","010");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        UserType userType = userTypeService.save(userType_a);
        assertNotNull(userType);
    }

    @Test
    @Order(2)
    void read() {
        Optional<UserType> read = this.userTypeService.read("user01");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("user01", userType_a.getUserId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.userTypeService.delete(userType_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.userTypeService.deleteById("user01");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}