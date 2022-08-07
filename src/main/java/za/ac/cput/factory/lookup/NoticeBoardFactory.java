package za.ac.cput.factory.lookup;


//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import za.ac.cput.domain.lookup.NoticeBoard;
import za.ac.cput.util.Helper;

public class NoticeBoardFactory {
    public static NoticeBoard noticeBoard(String flightID, String FlightName, String departureTime, String arrivalTime) {

        Helper.checkStringParam("flightID", flightID);
        Helper.checkStringParam("flightName", FlightName);
        Helper.checkStringParam("departureTime", departureTime);
        Helper.checkStringParam("arrivalTime", arrivalTime);

            return new NoticeBoard.Builder().setFlightID(flightID).setFlightName(FlightName).setDepartureTime(departureTime).setArrivalTime(arrivalTime).build();
        }
    }
