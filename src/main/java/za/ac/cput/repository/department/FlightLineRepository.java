package za.ac.cput.repository.department;
/*
  Dieuci Djate Nsibu
  220169136
  */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.FlightLine;

public interface FlightLineRepository extends JpaRepository<FlightLine,Integer> {

}
