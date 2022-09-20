package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.department.LuggageFactory;
import za.ac.cput.factory.lookup.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private TicketController controller;
    Autowired private TestTemplate restTemplate;
    private Ticket ticket;
    private String baseUrl;
    @BeforeEach
    void setup(){
        this.ticket = TicketFactory.createTicket("cape town");
        this.baseUrl = "http://localhost:" + this.port + "/Adp/ticket/";
    }
    @Test
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Ticket> response = this.restTemplate.postForEntity(url, this.ticket, Ticket.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
        
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.ticket.getDestination();
        System.out.println(url);
        ResponseEntity<Ticket> response = this.restTemplate.getForEntity(url, Ticket.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.ticket.getDestination();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "getAll";
        System.out.println(url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }
}