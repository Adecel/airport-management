package za.ac.cput.controller.department;

//Mogamad Tawfeeq Cupido+
//216266882
//21 August 2022

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Flight;
import za.ac.cput.service.departement.FlightService;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("airport-management/department/flight/")
@Slf4j
public class FlightController {


    final FlightService flightService;
    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping("save")
    public ResponseEntity<Flight> save(@Valid @RequestBody Flight flight) throws Exception {
      log.info("Save request: {}", flight);
//      Flight obj;
//      try {
//           obj = FlightFactory.flight(flight.getFlightID(), flight.getCapacity(), flight.getDepartureTime(), flight.getArrivalTime());
//      } catch (IllegalArgumentException e) {
//          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//      }
        Flight save = flightService.save(flight);
      return ResponseEntity.ok(save);

    }

    @GetMapping("read/{flightID}")
    public ResponseEntity<Flight> read(@PathVariable String flightID) {
        log.info("Read request: {}", flightID);
        Flight flight = flightService.read(flightID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(flight);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Flight flight) {
        log.info("Delete request: {}", flight);
        this.flightService.delete(flight);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Flight>>findAll() {
        List<Flight> flights = this.flightService.findAll();
        return ResponseEntity.ok(flights);
    }


}
