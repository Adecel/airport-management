package za.ac.cput.repository.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import za.ac.cput.domain.passenger.Passengers;


import java.util.Optional;

public interface PassengersRepository extends JpaRepository<Passengers, String> {
    Optional<Passengers> findById(@Param("PassengerID") String PassengerID);
}