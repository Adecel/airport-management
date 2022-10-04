package za.ac.cput.controller.passenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.service.passenger.Impl.PassengerTicketServiceImpl;
import za.ac.cput.service.passenger.PassengerTicketService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/passengerTicket")

public class PassengerTicketController {

    private final PassengerTicketService passengerTicketService;

    public PassengerTicketController(PassengerTicketServiceImpl passengerTicketService) {this.passengerTicketService = passengerTicketService;}

    @PostMapping("/save")
    public ResponseEntity<PassengerTicket> save(@RequestBody PassengerTicket passengerTicket) {
        log.info("Request to save PassengerTicket: {}", passengerTicket);
        PassengerTicket newPassengerTicket = passengerTicketService.save(passengerTicket);
        return ResponseEntity.ok(newPassengerTicket);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<PassengerTicket> read(@PathVariable String id) {
        log.info("Request to read PassengerTicket: {}", id);
        Optional<PassengerTicket> passengerTicket = passengerTicketService.read(id);
        return passengerTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/find/{passengerID}")
    public ResponseEntity<PassengerTicket> findById(@PathVariable String passengerID) {
        log.info("Request to find PassengerTicket: {}", passengerID);
        PassengerTicket passengerTicket = passengerTicketService.findByPassengerID(passengerID);
        return ResponseEntity.ok(passengerTicket);
    }
    @DeleteMapping("/delete/{passengerID}")
    public ResponseEntity delete(@PathVariable String passengerID) {
        log.info("Request to delete PassengerTicket: {}", passengerID);
        passengerTicketService.delete(passengerID);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deleteByID/{passsergerID}")
    public ResponseEntity deleteByID(@PathVariable String passengerID) {
        log.info("Request to delete PassengerTicket: {}", passengerID);
        passengerTicketService.deleteById(passengerID);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<PassengerTicket>> findAll() {
        log.info("Request to read all PassengerTickets");
        List<PassengerTicket> passengerTickets = passengerTicketService.findAll();
        return ResponseEntity.ok(passengerTickets);
    }

}


