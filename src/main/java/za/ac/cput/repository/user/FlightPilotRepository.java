package za.ac.cput.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.FlightPilot;

public interface FlightPilotRepository extends JpaRepository<FlightPilot, String> {

}
