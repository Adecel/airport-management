package za.ac.cput.factory.lookup;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.util.Helper;

public class NoticeBoardFactory {
    public static NoticeBoard createNoticeBoard(String FlightID, String FlightName, String ArrivalTime, String DepartureTime, String Destination){
        if (Helper.nullOrEmpty(FlightID)|| Helper.nullOrEmpty(FlightName) || Helper.nullOrEmpty(ArrivalTime) || Helper.nullOrEmpty(DepartureTime) || Helper.nullOrEmpty(Destination))
            return null;

        return new NoticeBoard.Builder().setFlightName(FlightName)
                .setFlightID(FlightID)
                .setArrivalTime(ArrivalTime)
                .setDepartureTime(DepartureTime)
                .setDestination(Destination)
                .build();

    }
}
