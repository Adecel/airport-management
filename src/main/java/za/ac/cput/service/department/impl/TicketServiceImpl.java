package za.ac.cput.service.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Ticket;
import za.ac.cput.factory.department.TicketFactory;
import za.ac.cput.repository.department.TicketRepository;
import za.ac.cput.service.department.TicketService;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;
    @Autowired
    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }
    @Override
    public Ticket save(Ticket ticket) {
        String id = ticket.getId();
        String userId = ticket.getUserId();
        String flightLineId = ticket.getFlightLineId();
        String seatNumber = ticket.getSeatNumber();
        String price = ticket.getPrice();
        String luggage = ticket.getLuggage();

        Ticket saving = TicketFactory.build(id, userId, flightLineId,
                seatNumber, price, luggage);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Ticket> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Ticket ticket) {
        this.repository.delete(ticket);
    }

    @Override
    public void deleteById(String id) {
        Optional<Ticket> ticket = read(id);
        if (ticket.isPresent()) {
            delete(ticket.get());
        }
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }
}
