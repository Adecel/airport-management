package za.ac.cput.repository.passenger;

import za.ac.cput.domain.passenger.PassengerContact;

import java.util.HashSet;
import java.util.Set;

public class PassengerContactRepo implements  IPassengerContactRepo {


    private static PassengerContactRepo repository = null;
    private Set<PassengerContact> passengerConDB = null;


    // private cons
    private PassengerContactRepo() {

        passengerConDB = new HashSet<PassengerContact>();

    }
    public static PassengerContactRepo getRepository(){

        if(repository==null) {

            repository = new PassengerContactRepo();
        }
        return repository;
    }




    @Override
    public PassengerContact create(PassengerContact passengerContact) {

        boolean success = passengerConDB.add(passengerContact);
        if(!success)
            return null;
        return passengerContact;
    }

    @Override
    public PassengerContact read(String passengerId) {
        for(PassengerContact p :passengerConDB) {
            if (p.getPassengerId().equals(passengerId))
                return p;
        }
        return null;

    }

    @Override
    public PassengerContact update(PassengerContact passengerContact) {

        PassengerContact oldPasscont = read(passengerContact.getPassengerId());

        if(oldPasscont!=null) {

            passengerConDB.remove(oldPasscont);
            passengerConDB.add(passengerContact);
            return passengerContact;
        }
        return null;
    }

    @Override
    public boolean delete(String passengerId) {

        PassengerContact passengerConToDelete = read(passengerId);
        if (passengerConToDelete == null)
            return false;
        passengerConDB.remove(passengerConToDelete);

        return true;
    }

    @Override
    public Set<PassengerContact> getAll() {
        return passengerConDB;
    }
}
