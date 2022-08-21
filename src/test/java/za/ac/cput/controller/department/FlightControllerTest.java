package za.ac.cput.controller.department;

//Mogamad Tawfeeq Cupido-
//216266882
//21 August 2022

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
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
        (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class FlightControllerTest {

    @LocalServerPort
    private int port;

@Autowired private FlightController controller;
@Autowired private TestRestTemplate restTemplate;

private Flight flight;
private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.flight = FlightFactory.flight("QWE-784", "5000", "15:00" ,"18:00");
        this.baseUrl = "http://localhost:" + this.port + "/airport-management/department/flight/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save/" + this.flight.getFlightID();
        System.out.println(url);
        ResponseEntity<Flight> response = this.restTemplate.postForEntity(url,this.flight, Flight.class);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }

    @Test
    void b_read() {
        String url = baseUrl + "read/" + this.flight.getFlightID();
        System.out.println(url);
        ResponseEntity<Flight> response = this.restTemplate.getForEntity(url, Flight.class);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }

    @Test
    void c_delete() {
        String url = baseUrl + "delete" + this.flight.getFlightID();
        this.restTemplate.delete(url);
    }

//    @Test
//    void findAll() {
//        String url = baseUrl + "All/" + this.flight.findAll();;
//        System.out.println(url);
//        ResponseEntity<Flight> response = this.restTemplate.getForEntity(url, Flight.class);
//        assertAll(
//                () ->assertEquals(HttpStatus.OK, response.getStatusCode())
//
//        );
//
//    }
}