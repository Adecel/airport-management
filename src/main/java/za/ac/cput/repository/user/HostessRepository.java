package za.ac.cput.repository.user;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.user.Hostess;

import java.util.List;
@Repository
public interface HostessRepository extends JpaRepository<Hostess, Integer> {
//    List<Hostess> findAllByUserId(String userId);
//    List<Hostess>findAllByFlightId(String flightId);
//    List<Hostess>findAllByDate(String date);
//    List<Hostess>findAllByDateAndFlightId(String date,String flightId);

}
