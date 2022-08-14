package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.repository.lookup.TicketRepository;
import za.ac.cput.service.lookup.TicketService;

import java.util.Optional;

public class TicketServiceImpl implements TicketService {
    private TicketRepository repository;

    @Autowired
    TicketServiceImpl(TicketRepository repository) {this.repository = repository;}
    @Override
    public Ticket save(Ticket ticket) {return this.repository.save(ticket);}

    @Override
    public Optional<Ticket> read(String s) {return this.repository.findById(s);}

    @Override
    public void delete(Ticket ticket) {this.repository.delete(ticket);}

//    @Override
//    public boolean delete(String id) {
//        if (this.repository.existsById(id)) {
//            this.repository.deleteById(id);
//            return true;
//        }
//        return false;
//
//    }

    @Override
    public Ticket FindByTicketID(String ticketID) {return this.repository.findByTicketID(ticketID);}


}



