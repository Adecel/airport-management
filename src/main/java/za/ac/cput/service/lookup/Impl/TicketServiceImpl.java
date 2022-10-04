package za.ac.cput.service.lookup.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.repository.lookup.TicketRepository;
import za.ac.cput.service.lookup.TicketService;
import za.ac.cput.util.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository) {this.repository = repository;}

    @Override
    public Ticket save(Ticket ticket) {return repository.save(ticket);}

    @Override
    public Optional<Ticket> read(String s) {return Optional.empty();}

    @Override
    public boolean delete(String a) {return false;}

    @Override
    public List<Ticket> findAll() {return repository.findAll();}

    @Override
    public Ticket findByTicketID(String ticketID) {
        return repository.findByTicketID(ticketID);
//                .orElseThrow(() -> new UserNotFoundException("This ID" + ticketID + "does not exist"));
    }

    @Override
    public void deleteById(String ticketID) { repository.deleteById(ticketID); }
}


