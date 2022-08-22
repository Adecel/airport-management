package za.ac.cput.service.departement.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.factory.department.AirportManagementFactory;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AirportManagementServiceImplTest {

    @Autowired
    private AirportManagementServiceImpl airportManagementService;
    private static AirportManagement airportManagement01 =
            AirportManagementFactory.build("Cape Town Airport",
                    "Cape Town", "South Africa");
    @Test
    void save() {
        System.out.println("Saved");
        AirportManagement airportManagement = airportManagementService.save(airportManagement01);
        assertNotNull(airportManagement);
        System.out.println(airportManagement);
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }
}