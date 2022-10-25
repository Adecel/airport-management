package za.ac.cput.controller.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Ticket;
import za.ac.cput.service.department.impl.TicketServiceImpl;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
@Slf4j
@CrossOrigin(origins = "*")
public class TicketController {
    private final TicketServiceImpl ticketService;
    @Autowired
    public TicketController(TicketServiceImpl ticketService) {this.ticketService = ticketService;}

    @PostMapping("/save")
    public ResponseEntity<Ticket> save(@Valid @RequestBody Ticket ticket) {
       log.info("Request to save ticket: {}", ticket);
            Ticket input = ticketService.save(ticket);
            return ResponseEntity.ok(input);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Ticket> read(@PathVariable String id) {
        log.info("Request to read ticket: {}", id);
        Optional<Ticket> ticket = Optional.ofNullable(ticketService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found")));
        return ResponseEntity.ok(ticket.get());
    }
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Ticket>> findAll() {
        log.info("Request to read all tickets");
        Iterable<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@Valid @RequestBody Ticket ticket) {
        log.info("Request to delete ticket: {}", ticket);
        ticketService.delete(ticket);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        log.info("Request to delete ticket: {}", id);
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
