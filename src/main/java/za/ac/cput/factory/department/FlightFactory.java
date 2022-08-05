package za.ac.cput.factory.department;
//220169136 DIEUCI DJAtE NSIBU

import za.ac.cput.domain.department.Flight;
import za.ac.cput.util.Helper;


public class FlightFactory {
    public static Flight createFlight (String flightID, String capacity, String departureTime, String arrivalTime){
        String flightHelp = Helper.generateID();
        return new Flight.Builder().setFlightID(flightID)
                .setCapacity(capacity)
                .setDepartureTime(departureTime)
                .setArrivalTime(arrivalTime)
                .build();
    }
}
