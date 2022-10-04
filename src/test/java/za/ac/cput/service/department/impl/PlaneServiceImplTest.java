package za.ac.cput.service.department.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.factory.department.PlaneFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PlaneServiceImplTest {

    @Autowired
    private PlaneServiceImpl planeService;
    private static Plane plane_a =
            PlaneFactory.build("99Air87B5","lufthansa",
                    "A330 - 7.3 tonnes of cargo", "Airbus A333-300");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Plane plane = planeService.save(plane_a);
        assertNotNull(plane);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Plane> read = this.planeService.read("99Air87B5");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("99Air87B5", plane_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.planeService.delete(plane_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.planeService.deleteById("99Air87B5");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}