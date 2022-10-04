package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.Hostess;
import za.ac.cput.factory.user.HostessFactory;
import za.ac.cput.repository.user.HostessRepository;
import za.ac.cput.service.user.HostessService;

import java.util.List;
import java.util.Optional;

@Service
public class HostessServiceImpl implements HostessService {

    private final HostessRepository repository;
    @Autowired
    public HostessServiceImpl(HostessRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hostess save(Hostess hostess) {
        String id = hostess.getId();
        String flightId = hostess.getFlightId();
        String userId = hostess.getUserId();
        String date = hostess.getDate();

        Hostess saving = HostessFactory.build(id, flightId, userId, date);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Hostess> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Hostess hostess) {
        this.repository.delete(hostess);
    }

    @Override
    public void deleteById(String id) {
        Optional<Hostess> hostess = read(id);
        if (hostess.isPresent()) {
            delete(hostess.get());
        }
    }

    @Override
    public List<Hostess> findAll() {
        return this.repository.findAll();
    }
}
