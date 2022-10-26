package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Hostess;
import za.ac.cput.factory.user.HostessFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class HostessServiceImplTest {

    @Autowired
    private HostessServiceImpl hostessService;
    private static Hostess hostess_a =
            HostessFactory.build(17,
                    new Name("Jeanne", "Doe", "Smith"),
                    new Gender("F", "ss"),"18:25 - 2022/09/30");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Hostess hostess = hostessService.save(hostess_a);
        assertNotNull(hostess);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Hostess> read = this.hostessService.read(17);
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals(17, hostess_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.hostessService.delete(hostess_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.hostessService.deleteById(17);
    }

    @Test
    @Order(3)
    void findAll() {
    }
}