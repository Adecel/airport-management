package za.ac.cput.service.departement.impl;

//Mogamad Tawfeeq Cupido
//216266882
//21 August 2022


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class FlightServiceImplTest {
    @Autowired
    private FlightServiceImpl flightService;
    Flight flight = FlightFactory.flight("CEZ-2150", "100", "10:50","18:00");


    @Test
    void a_save() {
        Flight flight1 = flightService.save(flight);
        assertNotNull(flight1);
    }



    @Test
    void b_read() {
        Optional<Flight> read = this.flightService.read("CEZ-2150");
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_delete() {
        this.flightService.delete(flight);

    }

    @Test
    void c_findById() {
        Optional<Flight> flight1 = this.flightService.findById("CEZ-2150");
        assertNotNull(flight1);
        System.out.println(flight1);
        assertAll(
                () -> assertEquals("CEZ-2150", flight.getFlightID())
        );
    }
}