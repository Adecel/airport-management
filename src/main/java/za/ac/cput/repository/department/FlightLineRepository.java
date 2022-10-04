package za.ac.cput.repository.department;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.FlightLine;

public interface FlightLineRepository extends JpaRepository<FlightLine, String> {

}
