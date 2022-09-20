package za.ac.cput.controller.lookup;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.factory.lookup.GenderFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
@Slf4j
class GenderControllerTest {

    @LocalServerPort
    private  int port;
    @Autowired
    private GenderController controller;

    @Autowired
    private TestRestTemplate restTemplate;
    private Gender gender;
    private String baseURL;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.getGender("Female");
        this.baseURL="http://localhost:"+ this.port+"/airport-management/Gender";
        a_save();
    }
    @Test
    void a_save() {
        String url=baseURL+"/save";
        ResponseEntity<Gender> response=this.restTemplate
                .postForEntity(url,this.gender,Gender.class);
        log.info("Error: ",response);
        System.out.println(response.toString());
        assertNotNull(response.getBody());
    }
    @Test
    void b_read() {
        String url= baseURL+ "/read/"+ gender.getGenName();
        ResponseEntity<Gender> response=this.restTemplate.getForEntity(url,Gender.class);
        log.info("Error: ",response);

        assertNotNull(response);
    }
    @Test
    void d_delete() {
        String url=baseURL+ "/delete";
        this.restTemplate
                .delete(url, gender);

    }
    @Test
    void c_findALL() {
        String url=baseURL+"/getAll";
        ResponseEntity<Gender[]> response=this.restTemplate.getForEntity(url,Gender[].class);
        System.out.println("Contains---- "+response.toString());

        assertTrue(response.hasBody());
    }

}