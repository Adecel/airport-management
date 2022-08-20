package za.ac.cput.service.departement.impl;

//  216266882 Mogamad Tawfeeq Cupido

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.repository.department.FlightRepository;
import za.ac.cput.service.departement.FlightService;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private static FlightService SERVICE;
    @Autowired
    private FlightServiceImpl() {
        this.repository = (FlightRepository) FlightServiceImpl.SERVICE;
    }

    public static FlightService getService() {
        if (SERVICE == null)
            SERVICE = new FlightServiceImpl();
        return SERVICE;
    }


    @Override
    public Flight save(Flight flight) {
        return this.repository.save(flight);

    }

    @Override
    public Optional<Flight> read(String flightID) {
        return this.repository.findById(flightID);
    }

    @Override
    public void delete(Flight flight) {
        this.repository.delete(flight);
    }

    @Override
    public List<Flight> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Flight> findById(String flightID) {
        return this.repository.findById(flightID);
    }
}

