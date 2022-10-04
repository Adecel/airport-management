package za.ac.cput.service.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Line;
import za.ac.cput.factory.department.LineFactory;
import za.ac.cput.repository.department.LineRepository;
import za.ac.cput.service.department.LineService;

import java.util.List;
import java.util.Optional;

@Service
public class LineServiceImpl implements LineService {

    private final LineRepository repository;
    @Autowired
    public LineServiceImpl(LineRepository repository){
        this.repository = repository;
    }

    @Override
    public Line save(Line line) {
        String flightLineId = line.getFlightLineId();
        String flightId = line.getFlightId();

        Line saving = LineFactory.build(flightLineId, flightId);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Line> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Line line) {
        this.repository.delete(line);
    }

    @Override
    public void deleteById(String id) {
        Optional<Line> line = read(id);
        if (line.isPresent()) {
            delete(line.get());
        }
    }

    @Override
    public List<Line> findAll() {
        return this.repository.findAll();
    }
}
