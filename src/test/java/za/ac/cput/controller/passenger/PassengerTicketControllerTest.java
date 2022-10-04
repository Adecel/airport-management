package za.ac.cput.controller.passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.factory.passenger.PassengerTicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerTicketControllerTest {

    @LocalServerPort
    private int port;
    @Autowired private PassengerTicketController controller;
    @Autowired private TestRestTemplate restTemplate;
    private PassengerTicket passengerTicket;
    private String baseURL;


    @BeforeEach
    void setUp() {
        this.passengerTicket = PassengerTicketFactory.createPassengerTicket(1000);
        this.baseURL = "http://localhost:" + port + "/passengerTicket";
    }

    @Test
    void save() {
        String url = baseURL + "/save";
        ResponseEntity<PassengerTicket> postResponse = restTemplate.postForEntity(url, passengerTicket, PassengerTicket.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + passengerTicket.getPassengerID();
        System.out.println("URL: " + url);
        ResponseEntity<PassengerTicket> response = restTemplate.getForEntity(url, PassengerTicket.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void findById() {
        String url = baseURL + "/find/" + passengerTicket.getPassengerID();
        System.out.println("URL: " + url);
        ResponseEntity<PassengerTicket> response = restTemplate.getForEntity(url, PassengerTicket.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + passengerTicket.getPassengerID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void deleteByID() {
        String url = baseURL + "/delete/" + passengerTicket.getPassengerID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }
}