package za.ac.cput.controller.department;

//Mogamad Tawfeeq Cupido-
//216266882
//21 August 2022

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.service.departement.FlightService;

import java.util.List;

@RestController

@RequestMapping("airport-management/department/flight/")
public class FlightController {


    final FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping("save")
    public ResponseEntity<Flight> save(Flight flight) throws Exception {
      System.out.println("Save called");
      Flight save = flightService.save(flight);
      return ResponseEntity.ok(save);

    }

    @GetMapping("read/{flightID}")
    public ResponseEntity<Flight> read(@PathVariable String flightID) {
        System.out.println("read called");
        Flight flight = flightService.read(flightID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Flight flight) {
        System.out.println("Delete called");
        this.flightService.delete(flight);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Flight>>findAll() {
        System.out.println("findAll called");
        List<Flight> flights = this.flightService.findAll();
        return ResponseEntity.ok(flights);
    }


}
