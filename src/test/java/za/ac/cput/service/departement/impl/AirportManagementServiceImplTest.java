package za.ac.cput.service.departement.impl;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.factory.department.AirportManagementFactory;

import java.sql.SQLOutput;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AirportManagementServiceImplTest {

//    @Autowired
    private AirportManagementServiceImpl airportManagementService;
    private static AirportManagement airportManagement01 =
            AirportManagementFactory.build("Cape Town Airport",
                    "Cape Town", "South Africa");
    @Test
    @Order(1)
    void save() {
        System.out.println("Saved");
        AirportManagement airportManagement = airportManagementService.save(airportManagement01);
        assertNotNull(airportManagement);
        System.out.println(airportManagement);
    }

    @Test
    @Order(2)
    void read() {
        Optional<AirportManagement> readTest =
                this.airportManagementService.read(airportManagement01.getAirportName());
        assertNotNull(readTest);
        System.out.println(readTest);
    }

//    @Test
//    @Order(3)
//    void delete() {
//        this.airportManagementService.delete();
//    }
}