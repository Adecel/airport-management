package za.ac.cput;
/*
  Adecel Rusty Mabiala
  219197229
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication
public class AirportManagementSystem {

    public static void main(String[] args) {
        SpringApplication.run(AirportManagementSystem.class,args);

    }
}
