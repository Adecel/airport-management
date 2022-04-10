package za.ac.cput.factory;
//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.RunWay;
import za.ac.cput.util.Helper;

public class RunwayFactory {
    public static RunWay createRunway(String runwayNumber, String FlightName, String runwayStatus){
        if (Helper.nullOrEmpty(runwayNumber) || Helper.nullOrEmpty(FlightName) || Helper.nullOrEmpty(runwayStatus))
            return null;

        return new RunWay.Builder().setRunwayNumber(runwayNumber)
                .setFlightName(FlightName)
                .setRunwayStatus(runwayStatus)
                .build();


    }
}