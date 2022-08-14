package za.ac.cput.service.departement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.repository.department.FlightRepository;
import za.ac.cput.service.departement.FlightService;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;

    @Autowired
    public FlightServiceImpl(FlightRepository repository){
        this.repository = repository;
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
}
