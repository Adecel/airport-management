package za.ac.cput.factory.lookup;
//220169136 DIEUCI DJATE NSIBU

import org.hibernate.internal.util.StringHelper;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.util.Helper;


public class TicketFactory {
    public static Ticket createTicket(String destination) {
        String ticketID = Helper.generateID();
        if (Helper.isEmptyOrNull(ticketID))
            throw new IllegalArgumentException();
        return new Ticket.Builder().setTicketID(ticketID).setDestination(destination).build();
    }
}
