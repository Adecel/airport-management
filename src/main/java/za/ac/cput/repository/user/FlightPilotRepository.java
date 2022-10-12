package za.ac.cput.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.FlightPilot;

import java.util.List;
@Repository
public interface FlightPilotRepository extends JpaRepository<FlightPilot, String> {
    List<FlightPilot>findAllByUserId(String userId);
    List<FlightPilot>findAllByFlightId(String flightId);
    List<FlightPilot>findAllByDate(String date);
    List<FlightPilot>findAllByDateAndFlightId(String date,String flightId);
}
