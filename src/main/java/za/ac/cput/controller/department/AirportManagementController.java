package za.ac.cput.controller.department;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.AirportManagement;
import za.ac.cput.service.departement.AirportManagementService;

import java.util.List;

@RestController
@RequestMapping("airport/airportManagement/")
@Slf4j
//the full address is : http://localhost:8080/airport/airportManagement/save
//the full address is : http://localhost:8080/airport/airportManagement/read/airportName
public class AirportManagementController {

    private  final AirportManagementService airportManagementService;

//    @Autowired
    public AirportManagementController(AirportManagementService airportManagementService) {
        this.airportManagementService = airportManagementService;
    }

    @PostMapping("save")
    public ResponseEntity<AirportManagement> save(@RequestBody AirportManagement airportManagement){
        log.info("Save request: {}", airportManagement);
        AirportManagement save = airportManagementService.save(airportManagement);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{airportName}")
    public ResponseEntity<AirportManagement> read(@PathVariable String airportName){
        log.info("Read request: {}", airportName);
        AirportManagement airportManagement = this.airportManagementService.read(airportName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(airportManagement);
    }

    @DeleteMapping("delete/{airportName}")
    public ResponseEntity<Void> delete(@PathVariable String airportName) {
        log.info("Delete request: {}", airportName);
        this.airportManagementService.delete(airportName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<AirportManagement>> findByStudentId(String airportName) {
        List<AirportManagement> student = this.airportManagementService.findByAirportName(airportName);
        return ResponseEntity.ok(student);
    }
}
