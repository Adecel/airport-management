package za.ac.cput.service.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.service.IService;

import java.util.List;

public interface FlightPilotService extends IService<FlightPilot, String> {
    List<FlightPilot> findAllByUserId(String userId);
    List<FlightPilot>findAllByFlightId(String flightId);
    List<FlightPilot>findAllByDate(String date);
    List<FlightPilot>findAllByDateAndFLightId(String date,String flightId);

}
