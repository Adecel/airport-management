package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    public Ticket findByTicketID(String ticketID);

}

