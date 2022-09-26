package za.ac.cput.controller.lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.lookup.Ticket;
import za.ac.cput.service.lookup.Impl.TicketServiceImpl;
import za.ac.cput.service.lookup.TicketService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketServiceImpl ticketService) {this.ticketService = ticketService;}

    @PostMapping("/save")
    public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) {
        log.info("Request to create a ticket: {}", ticket);
        Ticket newTicket = ticketService.save(ticket);
        return ResponseEntity.ok(newTicket);
    }


    @GetMapping("/read/{ticketID}")
    public ResponseEntity<Ticket> read(@PathVariable String ticketID) {
        log.info("Request to read a ticket: {}", ticketID);
        Ticket ticket = ticketService.findByTicketID(ticketID);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/find/{ticketID}")
    public ResponseEntity<Ticket> findById(@PathVariable String ticketID) {
        log.info("Request to find a ticket: {}", ticketID);
        Ticket ticket = ticketService.findByTicketID(ticketID);
        return ResponseEntity.ok(ticket);
    }

    //    @PutMapping("/update")
//    public ResponseEntity<Ticket> update(@RequestBody Ticket ticket) {
//        log.info("Request to update a ticket: {}", ticket);
//        Ticket updatedTicket = ticketService.save(ticket);
//        return ResponseEntity.ok(updatedTicket);
//    }
//
    @DeleteMapping("/delete/{ticketID}")
    public ResponseEntity delete(@PathVariable String ticketID) {
        log.info("Request to delete a ticket: {}", ticketID);
        this.ticketService.deleteById(ticketID);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deletebyID/{ticketID}")
    public ResponseEntity deleteByID(@PathVariable String ticketID) {
        log.info("Request to delete a ticket: {}", ticketID);
        this.ticketService.deleteById(ticketID);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Ticket>> findtAll() {
        log.info("Request to get all tickets");
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.ok(tickets);
    }
}









