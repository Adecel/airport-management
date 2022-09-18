package za.ac.cput.service.passenger;

import org.springframework.data.repository.query.Param;
;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.passenger.Passengers;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface PassengersService extends IService<Passengers, String> {
    List<Passengers> findAll();
    void deleteByID(String id);

    Optional<Passengers> findById(@Param("PassengerID") String PassengerID);
}
