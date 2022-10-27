package za.ac.cput.controller.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.factory.user.UserTypeFactory;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserTypeControllerTest {

    @LocalServerPort
    private  int port = 8080;
    @Autowired
    private TestRestTemplate restTemplate;
    private UserType userType1 = UserTypeFactory.build("12254", "2536" );
    private String baseURL ="http://localhost:"+ this.port+"/airport-management/user-type";


    @Test
    @Order(1)
    void a_save() {
        String url = baseURL + "/save";
        ResponseEntity<UserType> response = this.restTemplate.postForEntity(url,this.userType1,UserType.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void c_getAll() {
        String url = baseURL + "/getall";
        ResponseEntity<String> response = this.restTemplate.getForEntity(url,String.class);
        System.out.println(response);
    }

    @Test
    @Order(2)
    void b_read() {
        String url= baseURL+ "/read/"+userType1.getUserId();
        System.out.println("URL: " + url);
        UserType response = restTemplate.getForObject(url, UserType.class);
//        assertNull(response);
        System.out.println("Read data: " + response);
    }

    @Test
    @Order(4)
    void d_delete() {
        String url = baseURL + "/delete/" + this.userType1.getUserId();
        this.restTemplate.delete(url);
    }


}