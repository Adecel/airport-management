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
    private Plane plane = PlaneFactory.build("01","Mango","650","Boeing");
    private String baseURL = "http://localhost:"+port+"/airport-management/plane";

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "/save";
        ResponseEntity<Plane> response = this.restTemplate.postForEntity(url,this.plane,Plane.class);
    }

    @Test
    @Order(2)
    void read() {
        String url = "http://localhost:" + port + "/airport-management/ticket/read/" + plane.getId();
        System.out.println("URL: " + url);
        Plane response = restTemplate.getForObject(url, Plane.class);
        assertNull(response);
        System.out.println("Read data: " + response);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = "http://localhost:" + port + "/airport-management/ticket/findAll";
        System.out.println("URL: " + url);
        Plane[] response = restTemplate.getForObject(url, Plane[].class);
        assertNull(response);
        System.out.println("Read data: " + response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = "http://localhost:" + port + "/airport-management/ticket/delete/" + plane.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = "http://localhost:" + port + "/airport-management/ticket/delete/" + plane.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }
}