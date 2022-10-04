package za.ac.cput.service.contact.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ContactTypeServiceImplTest {

    @Autowired
    private ContactTypeServiceImpl contactTypeService;
    private static ContactType contactType_a =
            ContactTypeFactory.build("01","rusty@gmail.com",
                    "0913633440", "contact for Employee");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        ContactType contactType = contactTypeService.save(contactType_a);
        assertNotNull(contactType);
    }

    @Test
    @Order(2)
    void read() {
        Optional<ContactType> read = this.contactTypeService.read("01");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("01", contactType_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.contactTypeService.delete(contactType_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.contactTypeService.deleteById("01");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}