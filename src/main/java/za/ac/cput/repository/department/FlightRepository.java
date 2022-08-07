package za.ac.cput.repository.department;

//216266882 Mogamad Tawfeeq Cupido
//2022/08/07

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

}
