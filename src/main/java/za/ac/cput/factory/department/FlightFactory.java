package za.ac.cput.factory.department;
/*
  Dieuci Djate Nsibu
  220169136
  */

import za.ac.cput.domain.department.Flight;
import za.ac.cput.util.Helper;

public class FlightFactory {

    public static Flight build(String id, String departureDateAndTime, String arrivalDateAndTime,
                                String description, String departureLocation) {

        Helper.checkStringParam("FlightId", id);
        Helper.checkStringParam("departureDateAndTime", departureDateAndTime);
        Helper.checkStringParam("arrivalDateAndTime", arrivalDateAndTime);
        Helper.checkStringParam("description", description);
        Helper.checkStringParam("departureLocation", departureLocation);

        return Flight.builder().id(id).departureDateAndTime(departureDateAndTime)
                .arrivalDateAndTime(arrivalDateAndTime)
                .description(description).departureLocation(departureLocation)
                .build();
    }
}
