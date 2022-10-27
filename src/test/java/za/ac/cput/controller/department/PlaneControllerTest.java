package za.ac.cput.controller.department;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.domain.department.Ticket;
import za.ac.cput.factory.department.PlaneFactory;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class PlaneControllerTest {

    @LocalServerPort
    private int port=8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private Plane plane = PlaneFactory.build(90,"Mango","650","Boeing");
    private String baseURL = "http://localhost:"+port+"/airport-management/plane";

    @Test
    @Order(1)
    void save() {
        String url = baseURL+"/save";
        ResponseEntity<Plane> response = this.restTemplate.postForEntity(url, this.plane, Plane.class);
        assertEquals(response.getStatusCode().value(),404);
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL+"/read/"+plane.getId();
        ResponseEntity<Plane> response = this.restTemplate.getForEntity(url, Plane.class);
        assertEquals(response.getStatusCode().value(),404);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseURL + "/all";
        System.out.println("URL: " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }


    @Test
    @Order(4)
    void delete() {
        String url = "http://localhost:" + port + "/airport-management/plane/delete/" + plane.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = "http://localhost:" + port + "/airport-management/plane/delete/" + plane.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}