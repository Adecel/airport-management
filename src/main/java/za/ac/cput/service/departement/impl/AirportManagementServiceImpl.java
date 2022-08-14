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

import java.util.Optional;
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
    public Optional<AirportManagement> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(AirportManagement airportManagement) {

    }
}
