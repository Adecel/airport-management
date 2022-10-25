package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.FlightPilot;
import za.ac.cput.service.user.impl.FlightPilotServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/flight-pilot")
@Slf4j
@CrossOrigin(origins = "*")
public class FlightPilotController {

    private final FlightPilotServiceImpl service;

    @Autowired
    public FlightPilotController (FlightPilotServiceImpl service) {this.service = service;}
    //
    @PostMapping("/save")
    public ResponseEntity<FlightPilot> save (@RequestBody FlightPilot fightPilot){
        log.info("Request to save plane: {}", fightPilot);
        FlightPilot input = service.save(fightPilot);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <FlightPilot> read (@PathVariable String id)
    {
        log.info("Request to read plane: {}", id);
        FlightPilot input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }



    @GetMapping("/findAll")
    public ResponseEntity <List<FlightPilot>> findAll (){
        log.info("Request to read all planes");
        List <FlightPilot> flightPilot = this.service.findAll();
        return ResponseEntity.ok(flightPilot);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <FlightPilot> delete (FlightPilot flightPilot){
        log.info("Request to delete plane: {}", flightPilot);
        this.service.delete(flightPilot);
        return ResponseEntity.ok(flightPilot);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <FlightPilot> deleteById(@PathVariable String id){
        log.info("Request to delete plane: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FlightPilot> update(@RequestBody FlightPilot flightPilot, @PathVariable String id) {
        try {
            FlightPilot existPlane =service.read(id).orElse(null);
            service.save(flightPilot);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}

