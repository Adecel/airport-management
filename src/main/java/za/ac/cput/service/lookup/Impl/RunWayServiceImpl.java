package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.factory.lookup.RunwayFactory;
import za.ac.cput.repository.lookup.RunWayRepository;
import za.ac.cput.service.lookup.RunWayService;

import java.util.List;
import java.util.Optional;

@Service
public class RunWayServiceImpl implements RunWayService {
    private final RunWayRepository repository;

    @Autowired
    public RunWayServiceImpl(RunWayRepository repository){
        this.repository = repository;
    }

    @Override
    public RunWay save(RunWay runWay){
        String id = runWay.getRunwayNumber();
        String n = runWay.getFlightName();
        String st = runWay.getRunwayStatus();

        RunWay insert = RunwayFactory.createRunway(id, n, st);
        System.out.println("insert" + insert);
        return this.repository.save(insert);
    }

    @Override
    public Optional<RunWay> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(RunWay runWay) {
        this.repository.delete(runWay);

    }

    @Override
    public List<RunWay> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteByID(String id) {
        Optional<RunWay> runWay = read(id);
        if (runWay.isPresent()){
            delete(runWay.get());
        }

    }

    @Override
    public Optional<RunWay> findById(String runwayNumber) {
        return this.repository.findById(runwayNumber);

    }
}
