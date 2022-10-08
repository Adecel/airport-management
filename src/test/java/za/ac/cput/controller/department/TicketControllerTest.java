package za.ac.cput.controller.department;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.department.Ticket;
import za.ac.cput.factory.department.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class TicketControllerTest {
    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/contact";
    private Ticket ticket = TicketFactory.build("01","01","01","500","1000","1000");

    @Test
    @Order(1)
    void save() {
        String url = baseURL+"/save";
        ResponseEntity<Ticket> response = this.restTemplate.postForEntity(url,ticket,Ticket.class);
        assertEquals(response.getStatusCode().value(),401);
    }

    @Test
    @Order(2)
    void read() {
        String url = "http://localhost:" + port + "/airport-management/ticket/read/" + ticket.getId();
        System.out.println("URL: " + url);
        Ticket response = restTemplate.getForObject(url, Ticket.class);
        assertNull(response);
        System.out.println("Read data: " + response);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = "http://localhost:" + port + "/airport-management/ticket/findAll";
        System.out.println("URL: " + url);
        Ticket[] response = restTemplate.getForObject(url, Ticket[].class);
        assertNull(response);
        System.out.println("Read data: " + response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = "http://localhost:" + port + "/airport-management/ticket/delete/" + ticket.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void testDelete() {
        String url = "http://localhost:" + port + "/airport-management/ticket/delete";
        System.out.println("URL: " + url);
        restTemplate.delete(url, ticket);
    }
}