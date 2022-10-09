package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.service.user.impl.FlightPilotServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/airport-management/flight-pilot")
@Slf4j
public class FlightPilotController {
    private final FlightPilotServiceImpl service;

    @Autowired
    public FlightPilotController(FlightPilotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public FlightPilot create(@RequestBody FlightPilot flightPilot){
        return service.save(flightPilot);
    }

    @GetMapping("/read/{id}")
    public FlightPilot read(@PathVariable String id){
        return service.read(id).get();
    }

    @PostMapping("/delete")
    public void delete(@RequestBody FlightPilot flightPilot){
        service.delete(flightPilot);
    }

    @GetMapping("/read-all")
    public List<FlightPilot> readAll(){
        return service.findAll();
    }

    @GetMapping("/read-all-by-flight-id/{flightId}")
    public List<FlightPilot> readAllByFlightId(@PathVariable String flightId){
        return service.findAllByFlightId(flightId);
    }

    @GetMapping("/read-all-by-user-id/{userId}")
    public List<FlightPilot> readAllByUserId(@PathVariable String userId){
        return service.findAllByUserId(userId);
    }

    @GetMapping("/read-all-by-date/{date}")
    public List<FlightPilot> readAllByDate(@PathVariable String date){
        return service.findAllByDate(date);
    }

    @GetMapping("/read-all-by-date-flight-id/{date}/{flightId}")
    public List<FlightPilot> readAllByDateAndFlightId(@PathVariable String date, @PathVariable String flightId){
        return service.findAllByDateAndFLightId(date,flightId);
    }
}
