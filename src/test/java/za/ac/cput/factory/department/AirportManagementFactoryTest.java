package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.department.AirportManagementFactory;

import static org.junit.jupiter.api.Assertions.*;

class AirportManagementFactoryTest {

    @Test
    public void test() {
        AirportManagement airportManagement = AirportManagementFactory.management("Maya-Maya",
                "Brazzaville",
                "central of Africa");
        assertNotNull(airportManagement);

        System.out.println(airportManagement);
    }
}