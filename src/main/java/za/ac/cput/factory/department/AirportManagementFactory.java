package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.util.Helper;

public class AirportManagementFactory {

    public static AirportManagement build(String airportName, String cityName, String area) {
        Helper.checkStringParam("airportName", airportName);
        Helper.checkStringParam("cityName", cityName);
        Helper.checkStringParam("area", area);

        return new AirportManagement.Builder()
                .AirportName(airportName).CityName(cityName).Area(area).build();
    }
}
