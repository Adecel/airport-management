package za.ac.cput.controller.user;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.factory.user.UserCategoryFactory;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserCategoryControllerTest {


    @LocalServerPort
    private int port;
    @Autowired
    private UserCategoryController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private UserCategory userCategory;
    private String baseURL;


    @BeforeEach
    void setUp() {
        this.userCategory = UserCategoryFactory.build(100, "Admin", "Worker");
        this.baseURL = "http://localhost:" + port + "/api/userCategory";
    }

    @Test
    void save() {
        String url = baseURL + "/save";
        ResponseEntity<UserCategory> postResponse = restTemplate.postForEntity(url, userCategory, UserCategory.class);
        System.out.println(postResponse);
        assertAll(
                () -> assertNotNull(postResponse),
                () -> assertNotNull(postResponse.getBody())
        );
    }

    @Test
    void read() {
        String url = baseURL + "/read/" + userCategory.getId();
        System.out.println("URL: " + url);
        ResponseEntity<UserCategory> response = restTemplate.getForEntity(url, UserCategory.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void findById() {
        String url = baseURL + "/find/" + userCategory.getId();
        System.out.println("URL: " + url);
        ResponseEntity<UserCategory> response = restTemplate.getForEntity(url, UserCategory.class);
        System.out.println(response);
        assertAll(
                () -> assertNotNull(response),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseURL + "/delete/" + userCategory.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void deleteByID() {
        String url = baseURL + "/delete/" + userCategory.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
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


//    @LocalServerPort
//    private  int port = 7000;
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private UserCategory userCategory1 = UserCategoryFactory.build(12254, "Jake Mars",
//            "Test");
//    private String baseURL ="http://localhost:"+ this.port+"/airport-management/user-category";
//
//
//    @Test
//    @Order(1)
//    void a_save() {
//        String url = baseURL + "/save";
//        ResponseEntity<UserCategory> response = this.restTemplate.postForEntity(url,this.userCategory1,UserCategory.class);
//        System.out.println(response);
//
//    }
//
//    @Test
//    @Order(3)
//    void c_getAll() {
//        String url = baseURL + "/getAll";
//        System.out.println("URL: " + url);
//        UserCategory[] response = restTemplate.getForObject(url, UserCategory[].class);
////        assertNull(response);
//        System.out.println("Read data: " + response);
//    }
//
//
//    @Test
//    @Order(2)
//    void b_read() {
//        String url= baseURL+ "/read/"+userCategory1.getId();
//        System.out.println("URL: " + url);
//        UserCategory response = restTemplate.getForObject(url, UserCategory.class);
////        assertNull(response);
//        System.out.println("Read data: " + response);
//    }
//
//
//
//    @Test
//    @Order(4)
//    void d_delete() {
//        String url = baseURL + "/delete/" + this.userCategory1.getId();
//        this.restTemplate.delete(url);
//    }


}

//