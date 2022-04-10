package za.ac.cput.factory;
//220169136 DIEUCI DJATE NSIBU

import za.ac.cput.domain.entity.Ticket;
import za.ac.cput.util.Helper;

public class TicketFactory {
    public static Ticket createTicket (String ticketID,String destination){
        String ticketHelp = Helper.generateID();
        return new Ticket.Builder().setTicketID(ticketID)
                .setDestination(destination)
                .build();
    }
}
