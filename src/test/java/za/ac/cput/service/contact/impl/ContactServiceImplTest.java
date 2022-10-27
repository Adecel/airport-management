package za.ac.cput.service.contact.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.factory.contact.ContactFactory;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceImplTest {

    @Autowired public ContactServiceImpl service;
    public Contact contact;
    @BeforeEach
    void setUp() {
        this.contact=  ContactFactory.build(1,"0727408325","this maro hh");
       // this.employee1= EmployeeFactory.createEmployee("44","thh@gmail.com",this.name);
    }

    @Test
    void  save() {

        Contact contact= this.service.save(this.contact);
        System.out.println( contact.toString());
        assertNotNull(contact);
        // assertSame(this.employee1,employee);
    }

    @Test
    void read() {
        Contact contact= this.service.save(this.contact);
        Optional<Contact> read= this.service.read( contact.getId());
        assertAll(()->assertTrue(read.isPresent()));
    }



    @Test
    void delete() {
        this.service.delete(this.contact);
        List<Contact> contactList= this.service.findAll();
        assertEquals(1,contactList.size());

    }

    @Test
    void findAll() {
        this.service.save(this.contact );
        List< Contact > employeeList= this.service.findAll();
        assertEquals(1,employeeList.size());

    }
}