package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.user.Hostess;

import java.util.List;

public interface HostessRepository extends JpaRepository<Hostess, String> {
    List<Hostess> findAllByUserId(String userId);
    List<Hostess>findAllByFlightId(String flightId);
    List<Hostess>findAllByDate(String date);
    List<Hostess>findAllByDateAndFlightId(String date,String flightId);

}
