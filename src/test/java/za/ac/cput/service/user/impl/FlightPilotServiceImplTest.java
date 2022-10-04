package za.ac.cput.service.user.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.factory.user.FlightPilotFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class FlightPilotServiceImplTest {

    @Autowired
    private FlightPilotServiceImpl flightPilotService;
    private static FlightPilot flightPilot_a =
            FlightPilotFactory.build("Pi5","AA13Bus00",
                    "user01", "18:25 - 2022/09/30");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        FlightPilot flightPilot = flightPilotService.save(flightPilot_a);
        assertNotNull(flightPilot);
    }

    @Test
    @Order(2)
    void read() {
        Optional<FlightPilot> read = this.flightPilotService.read("Pi5");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("Pi5", flightPilot_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.flightPilotService.delete(flightPilot_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.flightPilotService.deleteById("Pi5");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}