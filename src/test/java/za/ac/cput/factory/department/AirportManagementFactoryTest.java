package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.factory.department.AirportManagementFactory;

import static org.junit.jupiter.api.Assertions.*;

class AirportManagementFactoryTest {

    @Test
    public void testWithSuccess() {
        AirportManagement airportManagement = AirportManagementFactory
                .build("Maya-Maya",
                "Brazzaville",
                "central of Africa");
        System.out.println(airportManagement);
        assertNotNull(airportManagement);
    }

    @Test
    public void testWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                AirportManagementFactory.build(null,
                        "Pointe-Noire",
                        "Central of Africa"));
        String exceptionMessage = exception.getMessage();
        assertSame("airport name is required!", exceptionMessage);
    }
}

