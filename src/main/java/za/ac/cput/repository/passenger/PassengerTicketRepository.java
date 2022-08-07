package za.ac.cput.repository.passenger;
//220169136 DIEUCI DJATE NSIBU
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.passenger.PassengerTicket;

public interface PassengerTicketRepository extends JpaRepository<PassengerTicket, String> {
    public PassengerTicket findByTicketID(String ticketID);
}

