package za.ac.cput.service.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.factory.department.FlightLineFactory;
import za.ac.cput.repository.department.FlightLineRepository;
import za.ac.cput.service.department.FlightLineService;

import java.util.List;
import java.util.Optional;

@Service
public class FlightLineServiceImpl implements FlightLineService {

    private final FlightLineRepository repository;
    @Autowired
    public FlightLineServiceImpl(FlightLineRepository repository){
        this.repository = repository;
    }

    @Override
    public FlightLine save(FlightLine flightLine) {
        String id = flightLine.getId();
        String description = flightLine.getDescription();
        String departure = flightLine.getDeparture();

        FlightLine saving = FlightLineFactory.build(id, description, departure);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<FlightLine> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(FlightLine flightLine) {
        this.repository.delete(flightLine);
    }

    @Override
    public void deleteById(String id) {
        Optional<FlightLine> flightLine = read(id);
        if (flightLine.isPresent()) {
            delete(flightLine.get());
        }
    }

    @Override
    public List<FlightLine> findAll() {
        return this.repository.findAll();
    }
}
