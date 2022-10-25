package za.ac.cput.controller.user;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.domain.user.Hostess;
import za.ac.cput.factory.user.HostessFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HostessControllerTest {

    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private Hostess hostess = HostessFactory.build("0134","ertertrsd","dfdrt4e34","10-20-22 03:40");
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/hostess";



    @Test
    void A_create() {
        String url = baseURL+"/create";
        ResponseEntity<Hostess> response=this.restTemplate.withBasicAuth("client","test").postForEntity(url, this.hostess, Hostess.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void B_read() {
        String url = baseURL+"/read/"+ hostess.getId();
        ResponseEntity<Hostess> response=this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void H_delete() {
        String url = baseURL+"/delete";
        ResponseEntity<Hostess> response=this.restTemplate.withBasicAuth("client","test").postForEntity(url,hostess, Hostess.class);
        assertEquals(response.getStatusCode().value(),200);
    }

    @Test
    void C_readAll() {
        String url = baseURL+"/read-all/";
        ResponseEntity<Hostess[]> response = this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void D_readAllByFlightId() {
        String url = baseURL + "/read-all-by-flight-id/"+ hostess.getFlightId();
        ResponseEntity<Hostess[]> response = this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void E_readAllByUserId() {
        String url = baseURL + "/read-all-by-user-id/"+ hostess.getUserId();
        ResponseEntity<Hostess[]> response = this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void F_readAllByDate() {
        String url = baseURL + "/read-all-by-date/"+ hostess.getDate();
        ResponseEntity<Hostess[]> response = this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void G_readAllByDateAndFlightId() {
        String url = baseURL + "/read-all-by-date-flight-id/"+ hostess.getDate()+"/"+ hostess.getFlightId();
        ResponseEntity<Hostess[]> response = this.restTemplate.withBasicAuth("client","test").getForEntity(url, Hostess[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}