package za.ac.cput.repository.department;
/*
  Mogamad Tawfeeq Cupido
  216266882
*/
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.department.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
