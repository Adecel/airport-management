package za.ac.cput.service.departement;

//216266882 Mogamad Tawfeeq Cupido

import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface FlightService extends IService<Flight, String> {

    List<Flight>  findAll();


    Optional<Flight> findById(@Param("flightID") String flightID);
}
