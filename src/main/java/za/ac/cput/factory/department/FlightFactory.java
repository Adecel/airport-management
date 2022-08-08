package za.ac.cput.factory.department;

//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import za.ac.cput.domain.department.Flight;
import za.ac.cput.util.Helper;


public class FlightFactory {
    public static Flight flight(String flightID, String capacity, String departureTime, String arrivalTime)

    {
        Helper.checkStringParam("flightID", flightID);
        Helper.checkStringParam("capacity", capacity);
        Helper.checkStringParam("departureTime", departureTime);
        Helper.checkStringParam("arrivalTime", arrivalTime);


        return new Flight.Builder().setFlightID(flightID).setCapacity(capacity).setDepartureTime(departureTime).setArrivalTime(arrivalTime).build();
    }
}
