package za.ac.cput.repository.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.passenger.PassengerContact;
@Repository
public interface PassengerContactRepository extends JpaRepository<PassengerContact,String > {

}
