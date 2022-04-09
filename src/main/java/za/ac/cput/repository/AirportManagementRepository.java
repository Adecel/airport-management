package za.ac.cput.repository;

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
//        AirportManagement airportManagementRead = airportManagementDB.stream()
//                .filter(am -> am.getAirportName().equals(airportName))
//                .findAny()
//                .orElse(null);
//        return null;

//        AirportManagement readAirport = read(airportName);
//        if(readAirport == null) {
//            return true;
//        }
//        return false;
        for (AirportManagement am : airportManagementDB) {
            if (am.getAirportName().equals(airportName))
                return am;
        }
        return null;
    }

    @Override
    public AirportManagement update(AirportManagement airportManagement) {
//        AirportManagement updateManagement = read(airportManagement.getAirportName());
//        if (updateManagement != null) {
//            airportManagementDB.remove(updateManagement);
//            airportManagementDB.add(airportManagement);
//            return airportManagement;
//        }
//        return null;

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
