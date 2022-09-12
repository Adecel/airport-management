package za.ac.cput.controller.passenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Passengers;
import za.ac.cput.service.PassengersService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Adp/passengers/")
@Slf4j

public class PassengerController {
    private final PassengersService passengersService;
    @Autowired
    public PassengerController(PassengersService passengersService){this.passengersService = passengersService;}
    @PostMapping("save")
    public ResponseEntity<Passengers> save(@Valid @RequestBody Passengers passengers){
        log.info("save request : {}", passengers);
        Passengers save = passengersService.save(passengers);
        return ResponseEntity.ok(save);
    }
    private Optional<Passengers> getById(String Id){return this.passengersService.read(Id);}
    @GetMapping("read/{id}")
    public ResponseEntity<Passengers> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Passengers passengers = this.passengersService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.OK));
        return  ResponseEntity.ok(passengers);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete request: {}", id);
        this.passengersService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Passengers>> findAll(){
        List<Passengers> passengers = this.passengersService.findAll();
        return  ResponseEntity.ok(passengers);
    }
}
