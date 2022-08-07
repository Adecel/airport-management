package za.ac.cput.factory.lookup;
//220169136 DIEUCI DJATE NSIBU

import org.hibernate.internal.util.StringHelper;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.util.Helper;


public class TicketFactory {
    public static Ticket createTicket(String ticketID, String destination) {
        return new Ticket.Builder().setTicketID(ticketID).setDestination(destination).build();
    }
}
