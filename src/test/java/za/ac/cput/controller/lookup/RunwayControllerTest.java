package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.RunWay;
import za.ac.cput.factory.RunwayFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class RunwayControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private RunwayController controller;
    @Autowired private TestRestTemplate restTemplate;
    private RunWay runWay;
    private  String baseUrl;

    @BeforeEach
    void setup(){
        this.runWay = RunwayFactory.createRunway("A323", "Lufthansa", "Empty");
        this.baseUrl = "http://localhost:" + this.port + "/Adp/runway/";
    }


    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<RunWay> response = this.restTemplate.postForEntity(url, this.runWay, RunWay.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "read/" + this.runWay.getRunwayNumber();
        System.out.println(url);
        ResponseEntity<RunWay> response = this.restTemplate.getForEntity(url, RunWay.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseUrl + "delete/" + this.runWay.getRunwayNumber();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<RunWay[]> response =
                this.restTemplate.getForEntity(url, RunWay[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertTrue(response.getBody().length==0)
        );

    }
}