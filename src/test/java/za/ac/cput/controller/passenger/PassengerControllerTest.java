package za.ac.cput.controller.passenger;

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
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.factory.passenger.PassengerContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PassengerControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private PassengerContactController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private PassengerContact passengerContact;
    private String baseURL;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.passengerContact = PassengerContactFactory
                .CreatePassengerCont("043","08777373");
        this.baseURL = "http://localhost:" + this.port + "/passenger-contact/";

    }
    @Test
    void a_save() {
        String url  = baseURL  + "save";
        System.out.println(url);

        ResponseEntity<PassengerContact> response = this.restTemplate
                .postForEntity(url , this.passengerContact, PassengerContact.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
                //  ()->assertNotNull(response.getBody())
        );
    }
    @Test
    void b_read() {
        String url = baseURL + "read" + this.passengerContact.getPassengerId();
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
        String url = baseURL + "delete" + this.passengerContact.getPassengerId();
        this.restTemplate.delete(url);
    }

    }