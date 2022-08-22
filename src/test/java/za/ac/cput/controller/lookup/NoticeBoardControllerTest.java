package za.ac.cput.controller.lookup;

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
import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.factory.lookup.NoticeBoardFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
        (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)

class NoticeBoardControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private NoticeBoardController controller;
    @Autowired private TestRestTemplate restTemplate;

    private NoticeBoard noticeBoard;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.noticeBoard = NoticeBoardFactory.noticeBoard("QWE-784", "5000","18:00", "15:00" ,"Dubai");
        this.baseUrl = "http://localhost:" + this.port + "/airport-management/department/flight/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save/" + this.noticeBoard.getFlightID();
        System.out.println(url);
        ResponseEntity<Flight> response = this.restTemplate.postForEntity(url,this.noticeBoard, Flight.class);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }

    @Test
    void b_read() {
        String url = baseUrl + "read/" + this.noticeBoard.getFlightID();
        System.out.println(url);
        ResponseEntity<Flight> response = this.restTemplate.getForEntity(url, Flight.class);
        assertAll(
                () ->assertEquals(HttpStatus.OK, response.getStatusCode())

        );
    }

    @Test
    void c_delete() {
        String url = baseUrl + "delete" + this.noticeBoard.getFlightID();
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