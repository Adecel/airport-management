package za.ac.cput.service.departement.impl;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.factory.department.AirportManagementFactory;
import za.ac.cput.repository.department.AirportManagementRepository;
import za.ac.cput.service.departement.AirportManagementService;

import java.util.List;
import java.util.Optional;

@Service
public class AirportManagementServiceImpl implements AirportManagementService {
    private final AirportManagementRepository repository;

    @Autowired
    public AirportManagementServiceImpl(AirportManagementRepository repository){
        this.repository = repository;
    }

    @Override
    public AirportManagement save(AirportManagement airportManagement) {
        String airportName = airportManagement.getAirportName();
        String cityName = airportManagement.getCityName();
        String area = airportManagement.getArea();

        AirportManagement saved = AirportManagementFactory.build(airportName, cityName, area);
        System.out.println("Saved" + saved);
        return this.repository.save(saved);
    }

    @Override
    public Optional<AirportManagement> read(String airportName) {
        return Optional.empty();
    }

    @Override
    public void delete(String airportManagement) {
        this.repository.delete(airportManagement);
    }


    @Override
    public List<AirportManagement> findByAirportName(String airportName) {
        return (List<AirportManagement>) this.repository.findByAirportName(airportName);
    }

    @Override
    public List<AirportManagement> findAll() {
        return this.repository.findAll();
    }

}
