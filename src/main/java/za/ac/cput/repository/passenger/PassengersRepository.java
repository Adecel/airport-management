package za.ac.cput.repository.passenger;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.passenger.Passengers;

import java.util.HashSet;
import java.util.Set;

public class PassengersRepository implements PRepository {


    public static PassengersRepository repository = null;
    private Set<Passengers> passengersDB = null;

    private PassengersRepository() {
        passengersDB = new HashSet<Passengers>();
    }

    public static PassengersRepository getRepository() {
        if (repository == null) {
            repository = new PassengersRepository();
        }
        return repository;
    }


    @Override
    public Passengers create(Passengers passengers) {
        boolean success = passengersDB.add(passengers);
        if (!success)
            return null;
        return passengers;
    }

    @Override
    public Passengers read(String PassengerID) {
        Passengers passengers = passengersDB.stream()
                .filter(h -> h.getPassengerID().equals(PassengerID))
                .findAny()
                .orElse(null);
        return passengers;
    }

    @Override
    public Passengers update(Passengers passengers) {
        Passengers oldPassenger = read(passengers.getPassengerID());
        if (oldPassenger != null) {
            passengersDB.remove(oldPassenger);
            passengersDB.add(passengers);
            return passengers;

        }
        return null;
    }

    @Override
    public boolean delete(String PassengerID) {
        Passengers passengersToDelete = read(PassengerID);
        if (passengersToDelete == null)
            return false;
        passengersDB.remove(passengersToDelete);
        return true;
    }

    @Override
    public Set<Passengers> getAll() {
        return passengersDB;
    }
}