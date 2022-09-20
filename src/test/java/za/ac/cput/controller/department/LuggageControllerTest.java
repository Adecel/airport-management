package za.ac.cput.controller.department;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.factory.department.LuggageFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class LuggageControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private LuggageController controller;
    @Autowired private TestRestTemplate restTemplate;
    private Luggage luggage;
    private  String baseUrl;

@BeforeEach
void setup(){
    this.luggage = LuggageFactory.build("3425563", "864", "WATER");
    this.baseUrl = "http://localhost:" + this.port + "/Adp/luggage/";
}
    @Test
    @Order(1)
    void save() {
    String url = baseUrl + "save";
        ResponseEntity<Luggage> response = this.restTemplate.postForEntity(url, this.luggage, Luggage.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
    String url = baseUrl + "read/" + this.luggage.getLuggageID();
        System.out.println(url);
        ResponseEntity<Luggage> response = this.restTemplate.getForEntity(url, Luggage.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
    String url = baseUrl + "delete/" + this.luggage.getLuggageID();
    this.restTemplate.delete(url);

    }

    @Test
    @Order(4)
    void findAll() {
    String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Luggage[]> response =
                this.restTemplate.getForEntity(url, Luggage[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );
    }
}