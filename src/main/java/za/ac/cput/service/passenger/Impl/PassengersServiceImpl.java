package za.ac.cput.service.passenger.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.repository.passenger.PassengerContactRepository;
import za.ac.cput.service.passenger.PassengerContactService;

import java.util.List;
import java.util.Optional;
@Service
public class PassengersServiceImpl implements PassengerContactService {

    private final PassengerContactRepository repository;

    @Autowired
    public PassengersServiceImpl(PassengerContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public PassengerContact save(PassengerContact passengerContact) {
        return this.repository.save(passengerContact);
    }

    @Override
    public Optional<PassengerContact> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(PassengerContact passengerContact) {
        this.repository.delete(passengerContact);

    }

    @Override
    public List<PassengerContact> findAll() {
        return this.repository.findAll();
    }
}