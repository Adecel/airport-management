package za.ac.cput.factory.department;


import za.ac.cput.domain.department.Flight;
import za.ac.cput.util.Helper;

public class FlightFactory {

    public static Flight build(String id, String departureDateAndTime, String arrivalDateAndTime,
                               String planeId, String description, String departureLocation) {

        Helper.checkStringParam("FlightId", id);
        Helper.checkStringParam("departureDateAndTime", departureDateAndTime);
        Helper.checkStringParam("arrivalDateAndTime", arrivalDateAndTime);
        Helper.checkStringParam("planeId", planeId);
        Helper.checkStringParam("description", description);
        Helper.checkStringParam("departureLocation", departureLocation);

        return Flight.builder().id(id).departureDateAndTime(departureDateAndTime)
                .arrivalDateAndTime(arrivalDateAndTime).planeId(planeId)
                .description(description).departureLocation(departureLocation)
                .build();
    }
}
