package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.lookup.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    public Ticket findByTicketID(String ticketID);
}

