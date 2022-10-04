package za.ac.cput.repository.department;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
