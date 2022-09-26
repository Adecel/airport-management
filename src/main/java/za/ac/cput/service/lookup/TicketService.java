package za.ac.cput.service.lookup;

import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.service.IService;

import java.util.List;

public interface TicketService extends IService<Ticket, String> {
    List<Ticket> findAll();
    Ticket findByTicketID(String ticketID);
    void deleteById(String ticketID);
}

