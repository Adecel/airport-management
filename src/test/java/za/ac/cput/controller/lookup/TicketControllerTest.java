package za.ac.cput.controller.lookup;

//220169136 DIEUCI DJATE NSIBU

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.factory.lookup.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class TicketControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private TicketController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Ticket ticket;
    private String baseURL;


    @BeforeEach
    void setUp() {
        this.ticket = TicketFactory.createTicket("Cape Town");
        this.baseURL = "http://localhost:" + port + "/ticket";
    }

    @Test
    void save() {
        String url = baseURL + "/save";
        ResponseEntity<Ticket> postResponse = restTemplate.postForEntity(url, ticket, Ticket.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + ticket.getTicketID();
        ResponseEntity<Ticket> response = restTemplate.getForEntity(url, Ticket.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void findById() {
        String url = baseURL + "/find/" + ticket.getTicketID();
        ResponseEntity<Ticket> response = restTemplate.getForEntity(url, Ticket.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + ticket.getTicketID();
        restTemplate.delete(url);
    }

    @Test
    void deleteByID() {
        String url = baseURL + "/delete/" + ticket.getTicketID();
        restTemplate.delete(url);
    }

    @Test
    void findtAll() {
        String url = baseURL + "/all";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }
}