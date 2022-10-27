package za.ac.cput.controller.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.factory.contact.ContactFactory;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.factory.user.FlightPilotFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class FlightPilotControllerTest {

    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private FlightPilot flight =  FlightPilot.builder().id("0134").flightId("ertertrsd").userId("dfdrt4e34").date("10-20-22 03:40").build();
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/flight-pilot";


    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<FlightPilot> postResponse = this.restTemplate.postForEntity(url, this.flight, FlightPilot.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + this.flight.getId();
        System.out.println("URL: " + url);
        ResponseEntity<FlightPilot> response = this.restTemplate.getForEntity(url, FlightPilot.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + this.flight.getId();
        System.out.println("URL: " + url);
        this.restTemplate.delete(url);
    }


    @Test
    void findAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }


    @Test
    void deleteByid() {
        String url = baseURL + "/delete/" + this.flight.getId();
        System.out.println("URL: " + url);
        this.restTemplate.delete(url);
    }
}