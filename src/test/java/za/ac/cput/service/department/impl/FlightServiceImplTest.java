package za.ac.cput.service.department.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class FlightServiceImplTest {

    @Autowired
    private FlightServiceImpl flightService;
    private static Flight flight_a =
            FlightFactory.build("AA13Bus00","19:25 - 2022/09/30",
                    "15:25 - 2022/09/31", "12UU24",
                    "only for business", "Cape Town");

    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        Flight flight = flightService.save(flight_a);
        assertNotNull(flight);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Flight> read = this.flightService.read("AA13Bus00");
        assertNotNull(read);
        System.out.println(read);
        assertAll(
                () -> assertEquals("AA13Bus00", flight_a.getId())
        );
    }

    @Test
    @Order(5)
    void delete() {
        System.out.println("deleted");
        this.flightService.delete(flight_a);
    }

    @Test
    @Order(4)
    void deleteById() {
        this.flightService.deleteById("AA13Bus00");
    }

    @Test
    @Order(3)
    void findAll() {
    }
}