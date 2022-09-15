package za.ac.cput.controller.passenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.service.passenger.PassengerTicketService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengerTicket")
@Slf4j

public class PassengerTicketController {
    @Autowired
    private  PassengerTicketService passengerTicketService;
@PostMapping("/save")
    public ResponseEntity<PassengerTicket> save(@RequestBody PassengerTicket passengerTicket) throws Exception {
        log.info("Save request: {}", passengerTicket);
        PassengerTicket save = passengerTicketService.save(passengerTicket);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<PassengerTicket> read(@PathVariable String id)  {
        log.info("Read request: {}", id);
        Optional<PassengerTicket> passengerTicket = this.passengerTicketService.read(id);
        return ResponseEntity.ok(passengerTicket.get());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> delete(@PathVariable PassengerTicket id) {
        log.info("Delete request: {}", id);
           this.passengerTicketService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/read/all")
    public ResponseEntity<List<PassengerTicket>> findAll() {
        log.info("Read all request");
        List<PassengerTicket> passengerTickets = this.passengerTicketService.findAll();
        return ResponseEntity.ok(passengerTickets);
    }
}


