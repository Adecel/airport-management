package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.factory.user.FlightPilotFactory;
import za.ac.cput.repository.user.FlightPilotRepository;
import za.ac.cput.service.user.FlightPilotService;

import java.util.List;
import java.util.Optional;

@Service
public class FlightPilotServiceImpl implements FlightPilotService {

    private final FlightPilotRepository repository;
    @Autowired
    public FlightPilotServiceImpl(FlightPilotRepository repository) {
        this.repository = repository;
    }

    @Override
    public FlightPilot save(FlightPilot flightPilot) {
        String id = flightPilot.getId();
        String flightId = flightPilot.getFlightId();
        String userId = flightPilot.getUserId();
        String date = flightPilot.getDate();

        FlightPilot saving = FlightPilotFactory.build(id, flightId, userId, date);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<FlightPilot> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(FlightPilot flightPilot) {
        this.repository.delete(flightPilot);
    }

    @Override
    public void deleteById(String id) {
        Optional<FlightPilot> flightPilot = read(id);
        if (flightPilot.isPresent()) {
            delete(flightPilot.get());
        }
    }

    @Override
    public List<FlightPilot> findAll() {
        return this.repository.findAll();
    }
}
