package za.ac.cput.service.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.factory.department.FlightFactory;
import za.ac.cput.repository.department.FlightRepository;
import za.ac.cput.service.department.FlightService;

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
        String id = flight.getId();
        String departureDateAndTime = flight.getDepartureDateAndTime();
        String arrivalDateAndTime = flight.getArrivalDateAndTime();
        String planeId = flight.getPlaneId();
        String description = flight.getDescription();
        String departureLocation = flight.getDepartureLocation();

        Flight saving = FlightFactory.build(id, departureDateAndTime, arrivalDateAndTime,
                planeId, description, departureLocation);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Flight> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Flight flight) {
        this.repository.delete(flight);
    }

    @Override
    public void deleteById(String id) {
        Optional<Flight> flight = read(id);
        if (flight.isPresent()) {
            delete(flight.get());
        }
    }

    @Override
    public List<Flight> findAll() {
        return this.repository.findAll();
    }
}
