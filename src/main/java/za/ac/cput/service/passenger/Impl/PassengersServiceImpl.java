package za.ac.cput.service.passenger.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.entity.Passengers;
import za.ac.cput.factory.PassengersFactory;
import za.ac.cput.repository.impl.PassengersRepository;
import za.ac.cput.service.PassengersService;

import java.util.List;
import java.util.Optional;

@Service
public class PassengersServiceImpl implements PassengersService {
    private  final PassengersRepository repository;

    @Autowired
    public PassengersServiceImpl(PassengersRepository repository){
        this.repository  = repository;
    }

    @Override
    public Passengers save(Passengers passengers) {
        String id = passengers.getPassengerID();
        String age = passengers.getPassengerAge();
        String fn = passengers.getPassengerFirstName();
        String ln = passengers.getPassengerLastName();


        Passengers insert = PassengersFactory.createPassengers(id, age, fn, ln);
        System.out.println("insert" + insert);
        return  this.repository.save(insert);
    }


    @Override
    public Optional<Passengers> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Passengers passengers) {
        this.repository.delete(passengers);
    }

    @Override
    public List<Passengers> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteByID(String id) {
        Optional <Passengers> passengers = read(id);
        if (passengers.isPresent()){
            delete(passengers.get());
        }

    }

    @Override
    public Optional<Passengers> findById(String PassengerID) {
        return this.repository.findById(PassengerID);
    }
}
