package za.ac.cput.service.departement.impl;

//216266882 Mogamad Tawfeeq Cupido


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.factory.department.LuggageFactory;

import java.util.List;
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
        Optional<Flight> flight2 = this.flightService.findById("CEZ-2150");
        assertNotNull(flight2);
        System.out.println(flight2);
        assertAll(
                () -> assertEquals("CEZ-2150", flight.getFlightID())
        );
    }
}