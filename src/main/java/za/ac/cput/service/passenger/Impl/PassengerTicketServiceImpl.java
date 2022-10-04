package za.ac.cput.service.passenger.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.repository.passenger.PassengerTicketRepository;
import za.ac.cput.service.passenger.PassengerTicketService;

import java.util.List;
import java.util.Optional;


@Service
public class PassengerTicketServiceImpl implements PassengerTicketService {
    private final PassengerTicketRepository repository;

    @Autowired
    public PassengerTicketServiceImpl(PassengerTicketRepository repository) {this.repository = repository;}


    @Override
    public PassengerTicket save(PassengerTicket passengerTicket) {return this.repository.save(passengerTicket);}

    @Override
    public Optional<PassengerTicket> read(String s) {return Optional.empty();}

    @Override
    public boolean delete(String a) {return false;}

    @Override
    public List<PassengerTicket> findAll() {return repository.findAll();}

    @Override
    public PassengerTicket findByPassengerID(String passengerID) {return repository.findByPassengerID(passengerID);}

    @Override
    public void deleteById(String passengerID) {
        repository.deleteById(passengerID);
    }
}

