package za.ac.cput.repository.lookup;


//220169136 Dieuci Djate Nsibu

import za.ac.cput.domain.lookup.Ticket;

import java.util.HashSet;
import java.util.Set;

public class TicketRepository implements ITicketRepository{
    private static TicketRepository repository = null;
    private Set <Ticket> ticketDB = null;


    private TicketRepository() {
        ticketDB = new HashSet<Ticket>();
    }

    public static TicketRepository getRepository() {
        if (repository == null)
            repository = new TicketRepository();

        return repository;
    }

    @Override
    public Ticket create(Ticket oj) {
        boolean success = ticketDB.add(oj);
        if (!success)
            return null;
        return oj;

    }

    @Override
    public Ticket read(String ticketID) {

        /*
            for (Ticket t : ticketDB)
                if (t.getTicketID().equals(ticketID))
                    return t;

            return null; */

        Ticket ticket= ticketDB.stream()
                .filter(t->t.getTicketID().equals(ticketID))
                .findAny()
                .orElse(null);
        return ticket;

    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket oldTicket = read(ticket.getTicketID());
        if (oldTicket !=null ){
            ticketDB.remove(oldTicket);
            ticketDB.add(ticket);
            return ticket;
        }
        return null;

    }

    @Override
    public boolean delete(String ticketID) {
        Ticket ticketToDelete = read(ticketID);
        if(ticketToDelete==null)
            return false;
        ticketDB.remove(ticketToDelete);
        return true;
    }

    @Override
    public Set<Ticket> getAll() {
        return ticketDB;
    }
}
