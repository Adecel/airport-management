package za.ac.cput.service.departement.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.repository.department.FlightRepository;
import za.ac.cput.service.departement.FlightService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Service
class FlightServiceImplTest {

    private Flight flight;
   @Autowired private FlightServiceImpl service;



    @BeforeEach
    void setUp() throws Exception {
//        Flight flight = new Flight.Builder().setFlightID("AQE252").setCapacity("5200").setDepartureTime("15:00").setArrivalTime("02:00").build();
        this.flight = FlightFactory.flight("AQE252","5200","15:00","02:00");
        Flight saved = this.service.save(this.flight);
        assertEquals(this.flight, saved);
    }

    @AfterEach
    void tearDown() {

        this.service.delete(this.flight);
        List<Flight> flightList = this.service.findAll();
        assertEquals(0, flightList.size());
    }


    @Test
    void read() {


        Optional<Flight> read = this.service.read(this.flight.getFlightID());
       System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(flight, read.get())

        );

//        return this.repository.findById(flightID);

     //   Optional<Flight> read = this.read(flightID);
    }

    @Test
    void findAll() {
        List<Flight> flightList = this.service.findAll();
        assertEquals(1, flightList.size());
    }
}