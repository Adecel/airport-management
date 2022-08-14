package za.ac.cput.service.lookup.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.factory.lookup.ContactFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest

class ContactServiceImplTest {

    private Contact contact;
    @Autowired private ContactServiceImpl service;

    @BeforeEach
    void setUp() {
        this.contact = ContactFactory.CreateContact("02","083552277","manager");
        Contact saved = this.service.save(this.contact);
        assertEquals(this.contact, saved);
    } // setup and save contact

    @AfterEach
    void tearDown() {
        this.service.delete(this.contact);
        List<Contact> contactList = this.service.findAll();
        assertEquals(0, contactList.size());
    }

    @Test
    void read() {
        Optional<Contact> read = this.service.read(contact.getConId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(contact, read.get())
        );
    }

    @Test
    void findAll() {
        List<Contact> contactList = this.service.findAll();
        assertEquals(1, contactList.size());
    }
}