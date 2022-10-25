package za.ac.cput.controller.user;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.factory.user.UserCategoryFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserCategoryControllerTest {

    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private UserCategory userCategory1 = UserCategoryFactory.build("12254", "Jake Mars",
            "Test");
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/user-category";

    @Test
    @Order(1)
    void a_save() {
        String url = baseURL + "/save";
        ResponseEntity<UserCategory> response = this.restTemplate.postForEntity(url,this.userCategory1,UserCategory.class);
        System.out.println(response);

    }

    @Test
    @Order(3)
    void c_getAll() {
        String url = baseURL + "/getAll";
        System.out.println("URL: " + url);
        UserCategory[] response = restTemplate.getForObject(url, UserCategory[].class);
//        assertNull(response);
        System.out.println("Read data: " + response);
    }


    @Test
    @Order(2)
    void b_read() {
        String url= baseURL+ "/read/"+userCategory1.getId();
        System.out.println("URL: " + url);
        UserCategory response = restTemplate.getForObject(url, UserCategory.class);
//        assertNull(response);
        System.out.println("Read data: " + response);
    }



    @Test
    @Order(4)
    void d_delete() {
        String url = baseURL + "/delete/" + this.userCategory1.getId();
        this.restTemplate.delete(url);
    }


}