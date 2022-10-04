package za.ac.cput.factory.user;

import za.ac.cput.domain.user.Hostess;
import za.ac.cput.util.Helper;

public class HostessFactory {
    public static Hostess build(String id, String flightId, String userId, String date) {
        Helper.checkStringParam("flightPilotId", id);
        Helper.checkStringParam("flightId", flightId);
        Helper.checkStringParam("userId", userId);
        Helper.checkStringParam("date", date);

        return Hostess.builder().id(id).flightId(flightId)
                .userId(userId).date(date).build();
    }
}
