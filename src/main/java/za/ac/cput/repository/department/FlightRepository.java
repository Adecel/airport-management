package za.ac.cput.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
