package za.ac.cput.factory;

import za.ac.cput.domain.entity.AirportManagement;
import za.ac.cput.util.Helper;

public class AirportManagementFactory {

    //user objects
//    public static AirportManagement management(String airportName, String cityName, String area){
//
//        if (Helper.nullOrEmpty(airportName)){
//            return null;
//        }
//
//        if (Helper.nullOrEmpty(cityName)){
//            return null;
//        }
//
//        if (Helper.nullOrEmpty(area)){
//            return null;
//        }
//
//        return new AirportManagement.Builder().setAirportName(airportName)
//                .setCityName(cityName).setArea(area).build();
//    }

    public static AirportManagement management(String airportName, String cityName, String area) {
        String airportManagementID = Helper.generateID();
        AirportManagement management = new AirportManagement.Builder()
                .setAirportName(airportName).setCityName(cityName)
                .setArea(area).build();
        return management;
    }

}
