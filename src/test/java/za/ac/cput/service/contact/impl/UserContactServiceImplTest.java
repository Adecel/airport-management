package za.ac.cput.service.contact.impl;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.UserContact;
import za.ac.cput.factory.contact.UserContactFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class UserContactServiceImplTest {

    @Autowired
    private UserContactServiceImpl userContactService;
    private static UserContact userContact_a =
            UserContactFactory.build(33,"2022/09/30");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        UserContact userContact = userContactService.save(userContact_a);
        assertNotNull(userContact);
    }

    @Test
    @Order(2)
    void read() {
        Optional<UserContact> read = this.userContactService.read(33);
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals(33, userContact_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.userContactService.delete(userContact_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.userContactService.deleteById(2);
    }

    @Test
    @Order(3)
    void findAll() {
    }
}