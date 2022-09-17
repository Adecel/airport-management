package za.ac.cput.controller.passenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.factory.passenger.PassengerTicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class PassengerTicketControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private PassengerTicketController controller;
    @Autowired private TestRestTemplate restTemplate;
    private PassengerTicket passengerTicket;
    private String baseUrl;
    @BeforeEach
    void setup(){
        this.passengerTicket = PassengerTicketFactory.createPassengerTicket(100);
        this.baseUrl = "http://localhost:" + this.port + "/Adp/passengerTicket/";
    }


    @Test
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<PassengerTicket> response = this.restTemplate.postForEntity(url, this.passengerTicket, PassengerTicket.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.passengerTicket.getPrice();
        System.out.println(url);
        ResponseEntity<PassengerTicket> response = this.restTemplate.getForEntity(url, PassengerTicket.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.passengerTicket.getPrice();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
}