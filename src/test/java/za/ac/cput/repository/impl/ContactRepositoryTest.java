package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.factory.lookup.ContactFactory;
import za.ac.cput.repository.lookup.ContactRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactRepositoryTest {


    public static ContactRepository repository = ContactRepository.getRepository();
    private static Contact contact = ContactFactory.CreateContact("001","0643990440","Manager");
    @Test



    void a_create() {
        Contact created = repository.create(contact);
        assertEquals(contact.getConId(),created.getConId());
        System.out.println("Creat: " + created);
    }

    @Test
    void b_read() {

        Contact read = repository.read(contact.getConId());
        assertNotNull(read);
        System.out.println("Read : "+read);
    }

    @Test
    void c_update() {
        Contact updated = new Contact.Builder().copy(contact).setConNumber("04947374933")
                .setConDescription("Owner")
                .build() ;
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(contact.getConId());
        assertTrue(success);
        System.out.println("Deleted : " + success);
    }

    @Test
    void d_getAll() {

        System.out.println("Show all : ");
        System.out.println(repository.getAll());
    }
}