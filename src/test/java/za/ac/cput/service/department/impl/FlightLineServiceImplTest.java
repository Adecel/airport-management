package za.ac.cput.service.department.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.factory.department.FlightLineFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class FlightLineServiceImplTest {

    @Autowired
    private FlightLineServiceImpl flightLineService;
    private static FlightLine flightLine_a =
            FlightLineFactory.build("Addis09667","Cape Town - Paris, via Addis ",
                    "Cape Town : 15:25 - 2022/09/31");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        FlightLine flightLine = flightLineService.save(flightLine_a);
        assertNotNull(flightLine);
    }

    @Test
    @Order(2)
    void read() {
        Optional<FlightLine> read = this.flightLineService.read("Addis09667");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("Addis09667", flightLine_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.flightLineService.delete(flightLine_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.flightLineService.deleteById("Addis09667");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}