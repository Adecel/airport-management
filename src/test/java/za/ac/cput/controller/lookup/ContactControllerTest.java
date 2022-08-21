package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.factory.lookup.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private ContactController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private Contact contact;
    private String baseURL;


    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.contact = ContactFactory
                .CreateContact("22","083763639","ceo!");
        this.baseURL = "http://localhost:" + this.port + "/contact/";

    }

    @Test
    void a_save() {
        String url  = baseURL  + "save";
        System.out.println(url);

        ResponseEntity<Contact> response = this.restTemplate
                .postForEntity(url , this.contact, Contact.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
                // ()->assertNotNull(response.getBody())
        );
    }

    @Test
    void b_read() {
        String url = baseURL + "read" +this.contact.getConId();
        System.out.println(url);
        ResponseEntity<Contact> response = this.restTemplate.getForEntity(url,
                Contact.class);
        // assertAll(
        //        () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        // () -> assertNotNull(response.getBody())
        // );
    }

    @Test
    void c_deleteById() {
        String url = baseURL + "delete" + this.contact.getConId();
        this.restTemplate.delete(url);
    }
}