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
    private  PassengerTicketRepository repository;
    @Autowired PassengerTicketServiceImpl(PassengerTicketRepository passengerTicketRepository) {this.repository = passengerTicketRepository;}

    @Override
    public PassengerTicket save(PassengerTicket passengerTicket) {return this.repository.save(passengerTicket);}

    @Override
    public Optional<PassengerTicket> read(String s) {return this.repository.findById(s);}

    @Override
    public void delete(PassengerTicket passengerTicket) {this.repository.delete(passengerTicket);}
//    @Override
//    public boolean delete(String s) {
//        if (this.repository.existsById(s)) {
//            this.repository.deleteById(s);
//            return true;
//        }
//        return false;
//    }

    @Override
    public PassengerTicket FindByTicketID(String ticketID) {return this.repository.findByTicketID(ticketID);}

    @Override
    public List<PassengerTicket> findAll() {return this.repository.findAll();}
}

