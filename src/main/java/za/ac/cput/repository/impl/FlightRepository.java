package za.ac.cput.repository.impl;
//220169136 Dieuci Djate Nsibu

import za.ac.cput.domain.entity.Flight;


import java.util.HashSet;
import java.util.Set;

public class FlightRepository  implements IFlightRepository{

    private static FlightRepository repository = null;
    private Set<Flight> flightDB = null;


    private FlightRepository() {
        flightDB = new HashSet<Flight>();
    }

    public static FlightRepository getRepository() {
        if (repository == null)
            repository = new FlightRepository();

        return repository;
    }

    @Override
    public Flight create(Flight oj) {
        boolean success = flightDB.add(oj);
        if (!success)
            return null;
        return oj;

    }

    @Override
    public Flight read(String flightID) {

        /*
            for (Ticket t : ticketDB)
                if (t.getTicketID().equals(ticketID))
                    return t;

            return null; */

        Flight ticket= flightDB.stream()
                .filter(t->t.getFlightID().equals(flightID))
                .findAny()
                .orElse(null);
        return ticket;

    }

    @Override
    public Flight update(Flight ticket) {
        Flight oldTicket = read(ticket.getFlightID());
        if (oldTicket !=null ){
            flightDB.remove(oldTicket);
            flightDB.add(ticket);
            return ticket;
        }
        return null;

    }

    @Override
    public boolean delete(String ticketID) {
        Flight ticketToDelete = read(ticketID);
        if(ticketToDelete==null)
            return false;
        flightDB.remove(ticketToDelete);
        return true;
    }

    @Override
    public Set<Flight> getAll() {
        return flightDB;
    }
}
