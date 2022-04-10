package za.ac.cput.repository.impl;


import za.ac.cput.domain.entity.PassengerTicket;

import java.util.HashSet;
import java.util.Set;

public class PassengerTicketRepository implements IPassengerTicketRepository {
    private static  PassengerTicketRepository  repository = null;
    private Set<PassengerTicket> passengerTicketDB = null;


    private PassengerTicketRepository() {
        passengerTicketDB = new HashSet<PassengerTicket>();
    }

    public static  PassengerTicketRepository  getRepository() {
        if (repository == null)
            repository = new PassengerTicketRepository();

        return repository;
    }

    @Override
    public PassengerTicket create(PassengerTicket oj) {
        boolean success = passengerTicketDB.add(oj);
        if (!success)
            return null;
        return oj;

    }

    @Override
    public PassengerTicket read(String passengerID) {

        PassengerTicket passengerTicket= passengerTicketDB.stream()
                .filter(t->t.getTicketID().equals(passengerID))
                .findAny()
                .orElse( null);
        return passengerTicket;

    }

    @Override
    public PassengerTicket update(PassengerTicket passengerticket) {
        PassengerTicket oldPassengerTicket = read(passengerticket.getTicketID());
        if (oldPassengerTicket !=null ){
            passengerTicketDB.remove(oldPassengerTicket);
            passengerTicketDB.add(passengerticket);
            return passengerticket;
        }
        return null;

    }

    @Override
    public boolean delete(String passengerID) {
        PassengerTicket passengerTicketToDelete = read(passengerID);
        if(passengerTicketToDelete==null)
            return true;
        passengerTicketDB.remove(passengerTicketToDelete);
        return true;
    }

    @Override
    public Set<PassengerTicket> getAll() {

        return passengerTicketDB;
    }
}



