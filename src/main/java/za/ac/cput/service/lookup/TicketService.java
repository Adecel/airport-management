package za.ac.cput.service.lookup;

import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.service.IService;

public interface TicketService extends IService<Ticket, String> {
    public Ticket FindByTicketID(String ticketID);
//    boolean delete(String ticketID);

}

