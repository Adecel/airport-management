package za.ac.cput.repository.impl;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.AirportManagement;

import java.util.HashSet;
import java.util.Set;

public class AirportManagementRepository implements IAirportManagementRepository{

    private static AirportManagementRepository repository = null;
    private Set<AirportManagement> airportManagementDB = null;

    private AirportManagementRepository() {
        airportManagementDB = new HashSet<AirportManagement>();
    }

    public static AirportManagementRepository getRepository() {
        if (repository == null){
            repository = new AirportManagementRepository();
        }
        return repository;
    }

    @Override
    public AirportManagement create(AirportManagement airportManagement) {
        boolean success = airportManagementDB.add(airportManagement);
        if (!success){
            return null;
        }
        return airportManagement;
    }

    @Override
    public AirportManagement read(String airportName) {
        for (AirportManagement am : airportManagementDB) {
            if (am.getAirportName().equals(airportName))
                return am;
        }
        return null;
    }

    @Override
    public AirportManagement update(AirportManagement airportManagement) {
        boolean update = airportManagementDB.add(airportManagement);
        if (!update){
            return null;
        }
        return airportManagement;
    }

    @Override
    public boolean delete(String airportName) {
        AirportManagement airportToBeDelete = read(airportName);
        if(airportToBeDelete == null) {
            return false;
        }
        airportManagementDB.remove(airportToBeDelete);

        return true;
    }

    @Override
    public Set<AirportManagement> getAll() {
        return airportManagementDB;
    }

}
