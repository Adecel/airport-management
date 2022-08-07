package za.ac.cput.factory.lookup;
//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.util.Helper;

public class RunwayFactory {
    public static RunWay createRunway(String runwayNumber, String FlightName, String runwayStatus){
        Helper.checkStringParam("runwayNumber", runwayNumber);
        Helper.checkStringParam("FlightName", FlightName);
        Helper.checkStringParam("runwayStatus", runwayStatus);
        return new RunWay.Builder().BuildRunwayNumber(runwayNumber)
                .BuildFlightName(FlightName)
                .BuildRunwayStatus(runwayStatus)
                .build();

    }
}