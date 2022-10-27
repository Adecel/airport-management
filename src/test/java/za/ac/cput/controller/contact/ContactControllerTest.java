package za.ac.cput.controller.contact;
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.factory.contact.ContactFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactControllerTest {

    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private Contact contact01 = ContactFactory.build(1, "0813623440",
            "Telekom phone Number");
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/contact";


//    @Test
//    @Order(1)
//    void save() {
//        String url = baseURL + "/save";
//        ResponseEntity<Contact> response = this.restTemplate.postForEntity(url, this.contact01, Contact.class);
//        System.out.println(response);
//        assertAll(
//                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                ()-> assertNull(response.getBody())
//        );
//    }

    @Test
    @Order(1)
    void a_save() {
        String url = baseURL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact01, Contact.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

//    @Test
//    @Order(3)
//    void c_getAll() {
//        String url=baseURL+"/getAll";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
//        assertEquals(response.getStatusCode().value(),200);
//    }

    @Test
    @Order(3)
    void c_getAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

//    @Test
//    @Order(2)
//    void read() {
//        String url = baseURL + "/read/" + this.contact01.getId();
//        System.out.println(url);
//        ResponseEntity<Contact> response = this.restTemplate.getForEntity(url, Contact.class);
//        System.out.println(response);
//        assertAll(
//                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                ()-> assertNotNull(response.getBody())
//        );
//    }
    @Test
    @Order(2)
    void b_read() {
        String url = baseURL + "/read/" + contact01.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> response = restTemplate.getForEntity(url, Contact.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

//    @Test
//    @Order(3)
//    void d_delete() {
//        String url=baseURL+ "/delete/"+contact01.getId();
//        this.restTemplate.delete(url);
//        String readURL= baseURL+ "/read/"+contact01.getId();
//        ResponseEntity<Contact> response=this.restTemplate.getForEntity(readURL,Contact.class);
//        assertEquals(response.getStatusCode().value(),404);
//    }

    @Test
    @Order(4)
    void d_delete() {
        String url = baseURL + "/delete/" + contact01.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}