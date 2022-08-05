package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.util.Helper;

public class AirportManagementFactory {

    public static AirportManagement management(String airportName, String cityName, String area) {
        String airportManagementID = Helper.generateID();
        AirportManagement management = new AirportManagement.Builder()
                .setAirportName(airportName).setCityName(cityName)
                .setArea(area).build();
        return management;
    }

}
