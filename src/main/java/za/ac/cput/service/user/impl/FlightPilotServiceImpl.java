package za.ac.cput.service.user.impl;
/*
  Name : Mahad Haasan
  student num: 219122822
  Capstone Project
 */
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
        return this.repository.save(flightPilot);
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

    @Override
    public List<FlightPilot> findAllByUserId(String userId) {
        return this.repository.findAllByUserId(userId);
    }

    @Override
    public List<FlightPilot> findAllByFlightId(String flightId) {
        return this.repository.findAllByFlightId(flightId);
    }

    @Override
    public List<FlightPilot> findAllByDate(String date) {
        return this.repository.findAllByDate(date);
    }

    @Override
    public List<FlightPilot> findAllByDateAndFLightId(String date, String flightId) {
        return this.repository.findAllByDateAndFlightId(date, flightId);
    }
}
