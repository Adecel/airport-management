package za.ac.cput.repository.passenger;
//220169136 DIEUCI DJATE NSIBU
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.passenger.PassengerTicket;
@Repository
public interface PassengerTicketRepository extends JpaRepository<PassengerTicket, String> {
    public PassengerTicket findByTicketID(String ticketID);
}

