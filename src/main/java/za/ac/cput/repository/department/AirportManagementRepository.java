package za.ac.cput.repository.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//CRUD is the goal.
public class AirportManagementRepository implements IRepository<AirportManagement, String> {

    /*Singletone */
    private final List<AirportManagement> airportManagementList;
    private static AirportManagementRepository AIRPORT_MANAGEMENT_REPOSITORY;

    private AirportManagementRepository(){
        this.airportManagementList = new ArrayList<>();
    }

    public static AirportManagementRepository airportManagementRepository(){
        if (AIRPORT_MANAGEMENT_REPOSITORY == null){
            AIRPORT_MANAGEMENT_REPOSITORY = new AirportManagementRepository();
        }
        return AIRPORT_MANAGEMENT_REPOSITORY;
    }

    public AirportManagement save(AirportManagement airportManagement) {
        Optional<AirportManagement> read = read(airportManagement.getAirportName());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.airportManagementList.add(airportManagement);
        return airportManagement;
    }

//    public AirportManagement create(AirportManagement airportManagement) {
//        this.airportManagementList.add(airportManagement);
//        return airportManagement;
//    }
//
//    public AirportManagement update(AirportManagement airportManagement) {
//        Optional<AirportManagement> read = read(airportManagement.getAirportName());
//        if (read.isPresent()) {
//            delete(read.get());
//            create(airportManagement);
//        }
//        return airportManagement;
//    }

    public Optional<AirportManagement> read(String airportName) {
        return  this.airportManagementList.stream()
                .filter(a -> a.getAirportName().equalsIgnoreCase(airportName))
                .findFirst();
    }

    public void delete(AirportManagement airportManagement) {
        this.airportManagementList.remove(airportManagement);
    }

    public List<AirportManagement> findAll() {
        return this.airportManagementList;
    }

}
