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
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
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
    private Hostess hostess = HostessFactory.build(1,
            new Name("Lisa", "Julieta", "Smith"), new Gender("F", "Hostess"), "021 123 4567");
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/hostess";



    @Test
    void A_create() {
        String url = baseURL + "/create";
        ResponseEntity<Hostess> postResponse = this.restTemplate.postForEntity(url, this.hostess, Hostess.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

    @Test
    void B_read() {
        String url = baseURL + "/read/" + this.hostess.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Hostess> response = this.restTemplate.getForEntity(url, Hostess.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void H_delete() {
        String url = baseURL + "/delete/" + this.hostess.getId();
        System.out.println("URL: " + url);
        this.restTemplate.delete(url);
    }

    @Test
    void C_readAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void D_readAllByFlightId() {
        String url = baseURL + "/all/" + this.hostess.getId();
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void E_readAllByUserId() {
        String url = baseURL + "/all/" + this.hostess.getId();
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void F_readAllByDate() {
        String url = baseURL + "/all/" + this.hostess.getId();
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void G_readAllByDateAndFlightId() {
        String url = baseURL + "/all/" + this.hostess.getId();
        System.out.println("URL: " + url);
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }
}