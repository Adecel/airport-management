package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Pilot;
import za.ac.cput.factory.user.PilotFactory;
import za.ac.cput.repository.user.PilotRepository;
import za.ac.cput.service.user.PilotService;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotService {

    private final PilotRepository repository;

    @Autowired
    public PilotServiceImpl(PilotRepository repository){
        this.repository = repository;
    }

    @Override
    public Pilot save(Pilot pilot) {
        int id = pilot.getId();
        Name name = pilot.getName();
        Gender gender = pilot.getGender();
        String phoneNumber = pilot.getPhoneNumber();

        Pilot saving = PilotFactory.build(id, name, gender, phoneNumber);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Pilot> read(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Pilot pilot) {
        this.repository.delete(pilot);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Pilot> pilot = read(id);
        if (pilot.isPresent()) {
            delete(pilot.get());
        }
    }

    @Override
    public List<Pilot> findAll() {
        return this.repository.findAll();
    }
}
