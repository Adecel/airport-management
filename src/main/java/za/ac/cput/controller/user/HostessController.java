package za.ac.cput.controller.user;
/*
 Name: Hilary Cassidy Nguepi Nangmo
 Student number: 220346887
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.user.Hostess;
import za.ac.cput.service.user.impl.HostessServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/airport-management/hostess")
public class HostessController {
    private final HostessServiceImpl hostessService;

    @Autowired
    public HostessController(HostessServiceImpl hostessService){
        this.hostessService= hostessService;
    }

    @PostMapping("/create")
    public Hostess create(@RequestBody Hostess hostess){
        return hostessService.save(hostess);
    }

    @GetMapping("/read/{id}")
    public Hostess read(@PathVariable String id){
        return hostessService.read(id).get();
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Hostess hostess){
        hostessService.delete(hostess);
    }

    @GetMapping("/read-all")
    public List<Hostess> readAll(){
        return hostessService.findAll();
    }

    @GetMapping("/read-all-by-flight-id/{flightId}")
    public List<Hostess> readAllByFlightId(@PathVariable String flightId){
        return hostessService.findAllByFlightId(flightId);
    }

    @GetMapping("/read-all-by-user-id/{userId}")
    public List<Hostess> readAllByUserId(@PathVariable String userId){
        return hostessService.findAllByUserId(userId);
    }

    @GetMapping("/read-all-by-date/{date}")
    public List<Hostess> readAllByDate(@PathVariable String date){
        return hostessService.findAllByDate(date);
    }

    @GetMapping("/read-all-by-date-flight-id/{date}/{flightId}")
    public List<Hostess> readAllByDateAndFlightId(@PathVariable String date, @PathVariable String flightId){
        return hostessService.findAllByDateAndFlightId(date, flightId);
    }

}
