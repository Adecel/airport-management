package za.ac.cput.controller.user;

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
    void A_create() {
        String url = baseURL+"/create";
        ResponseEntity<FlightPilot> response=this.restTemplate.withBasicAuth("user","test").postForEntity(url, this.flight, FlightPilot.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void B_read() {
        String url = baseURL+"/read/"+flight.getId();
        ResponseEntity<FlightPilot> response=this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void H_delete() {
        String url = baseURL+"/delete";
        ResponseEntity<FlightPilot> response=this.restTemplate.withBasicAuth("user","test").postForEntity(url, flight, FlightPilot.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void C_readAll() {
        String url = baseURL+"/read-all/";
        ResponseEntity<FlightPilot[]> response = this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void D_readAllByFlightId() {
        String url = baseURL + "/read-all-by-flight-id/"+flight.getFlightId();
        ResponseEntity<FlightPilot[]> response = this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void E_readAllByUserId() {
        String url = baseURL + "/read-all-by-user-id/"+flight.getUserId();
        ResponseEntity<FlightPilot[]> response = this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void F_readAllByDate() {
        String url = baseURL + "/read-all-by-date/"+flight.getDate();
        ResponseEntity<FlightPilot[]> response = this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void G_readAllByDateAndFlightId() {
        String url = baseURL + "/read-all-by-date-flight-id/"+flight.getDate()+"/"+flight.getFlightId();
        ResponseEntity<FlightPilot[]> response = this.restTemplate.withBasicAuth("user","test").getForEntity(url, FlightPilot[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}