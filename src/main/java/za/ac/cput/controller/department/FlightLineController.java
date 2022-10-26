package za.ac.cput.controller.department;
/*
  Dieuci Djate Nsibu
  220169136
  */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.department.FlightLine;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.service.department.impl.FlightLineServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
@Slf4j
@RestController
@RequestMapping("/api/flight-line")
@CrossOrigin(origins = "*")
public class FlightLineController {

    private final FlightLineServiceImpl flightLineService;

    @Autowired
    public FlightLineController(FlightLineServiceImpl flightLineServiceImpl) {this.flightLineService = flightLineServiceImpl;}
    //
    @PostMapping("/save")
    public ResponseEntity< FlightLine> save (@RequestBody FlightLine flightLine){
        log.info("Request to save plane: {}",  flightLine);
        FlightLine input = flightLineService.save( flightLine);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity <FlightLine> read (@PathVariable int id){
        log.info("Request to read plane: {}", id);
        FlightLine input = flightLineService.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<  FlightLine>> findAll (){
        log.info("Request to read all planes");
        List <  FlightLine> plane = this.flightLineService.findAll();
        return ResponseEntity.ok(plane);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <FlightLine> delete (FlightLine flightLine){
        log.info("Request to delete plane: {}", flightLine);
        this.flightLineService.delete(flightLine);
        return ResponseEntity.ok(flightLine);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Plane> deleteById(@PathVariable int id){
        log.info("Request to delete plane: {}", id);
        this.flightLineService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FlightLine> update(@RequestBody FlightLine flightLine, @PathVariable int id) {
        try {
            FlightLine existPlane = flightLineService.read(id).orElse(null);
            flightLineService.save(flightLine);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}
