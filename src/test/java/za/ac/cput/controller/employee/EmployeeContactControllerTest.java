package za.ac.cput.controller.employee;

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
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.factory.employee.EmployeeContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeContactControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private EmployeeContactController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private EmployeeContact employeeContact;
    private String baseURL;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
        this.employeeContact = EmployeeContactFactory
                .CreateEmployeeContact("83","083763639");
        this.baseURL = "http://localhost:" + this.port + "/employee-contact/";


    }
    @Test
    void a_save() {
        String Url  = baseURL  + "save";
        System.out.println(Url);

        ResponseEntity<EmployeeContact> response = this.restTemplate
                .postForEntity(Url ,this.employeeContact, EmployeeContact.class);
        System.out.println(response);
//        assertAll(
//                ()->assertEquals(HttpStatus.OK,response.getStatusCode())
//                // ()->assertNotNull(response.getBody())
//        );
    }

    @Test
    void b_read() {
        String url = baseURL + "read";
        System.out.println(url);
        ResponseEntity<EmployeeContact> response = this.restTemplate.getForEntity(url,
                EmployeeContact.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
                // () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
    }
}