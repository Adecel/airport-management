package za.ac.cput.controller.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.service.department.impl.FlightServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
@Slf4j
@RestController
@RequestMapping("/api/flight")
@CrossOrigin(origins = "*")
public class FlightController {

    private final FlightServiceImpl flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightServiceimpl) {this.flightService = flightServiceimpl;}
    @PostMapping("/save")
    public ResponseEntity<Flight> save (@RequestBody Flight flight){
        log.info("Request to save plane: {}",  flight);
        Flight input = flightService.save( flight);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity <Flight> read (@PathVariable String id){
        log.info("Request to read plane: {}", id);
        Flight input = flightService.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Flight>> findAll (){
        log.info("Request to read all planes");
        List <  Flight> flight = this.flightService.findAll();
        return ResponseEntity.ok(flight);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <Flight> delete (Flight flight){
        log.info("Request to delete plane: {}", flight);
        this.flightService.delete(flight);
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Flight> deleteById(@PathVariable String id){
        log.info("Request to delete plane: {}", id);
        this.flightService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> update(@RequestBody FlightLine flight, @PathVariable String id) {
        try {
            Flight existFlight = flightService.read(id).orElse(null);
            flightService.save(existFlight);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}

