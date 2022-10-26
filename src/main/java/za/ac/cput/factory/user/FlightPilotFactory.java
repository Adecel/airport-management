package za.ac.cput.factory.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */

import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.util.Helper;

public class FlightPilotFactory {

    public static FlightPilot build(String id, String flightId, String userId, String date) {
        Helper.checkStringParam("flightPilotId", id);
        Helper.checkStringParam("flightId", flightId);
        Helper.checkStringParam("userId", userId);
        Helper.checkStringParam("date", date);

        return FlightPilot.builder().id(id).flightId(flightId)
                .userId(userId).date(date).build();
    }
}
