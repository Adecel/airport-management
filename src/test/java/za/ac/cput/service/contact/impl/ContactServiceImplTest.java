package za.ac.cput.service.contact.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.factory.contact.ContactFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ContactServiceImplTest {

    @Autowired
    private ContactServiceImpl contactService;
    private static Contact contact_a =
            ContactFactory.build("01", "093457224", "Airtel Phone number");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Contact contact = contactService.save(contact_a);
        assertNotNull(contact);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Contact> read = this.contactService.read("01");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("01", contact_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.contactService.delete(contact_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.contactService.deleteById("01");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}