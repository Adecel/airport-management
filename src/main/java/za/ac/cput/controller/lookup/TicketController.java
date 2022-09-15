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
    private  TicketService ticketService;

    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;}

   @PostMapping("/save")
   public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) throws Exception {
       log.info("Save request: {}", ticket);
       Ticket save = ticketService.save(ticket);
       return ResponseEntity.ok(save);
   }
   @GetMapping("/read/{id}")
    public ResponseEntity<Ticket> read(@PathVariable String id)  {
        log.info("Read request: {}", id);
        Optional<Ticket> ticket = this.ticketService.read(id);
        return ResponseEntity.ok(ticket.get());
    }    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable Ticket ticketID) {
           log.info("Delete request: {}", ticketID);
            this.ticketService.delete(ticketID);
            return ResponseEntity.noContent().build();
    }
    @GetMapping("/read/all")
    public ResponseEntity<List<Ticket>> getAll() {
        log.info("Get all request");
        List<Ticket> tickets = this.ticketService.finAll();
        return ResponseEntity.ok(tickets);
    }
  }









