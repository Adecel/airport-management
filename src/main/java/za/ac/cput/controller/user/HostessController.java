package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.Hostess;
import za.ac.cput.service.user.impl.HostessServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/hostess")
@Slf4j
@CrossOrigin(origins = "*")
public class HostessController {
    private final HostessServiceImpl service;
    @Autowired
    public HostessController (HostessServiceImpl service) {
        this.service = service;
    }
    @PostMapping("/save")
    public ResponseEntity<Hostess> save (@RequestBody Hostess hostess){
        log.info("Request to save pilot: {}", hostess);
        Hostess input = service.save(hostess);
        return ResponseEntity.ok(input);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity <Hostess> read (@PathVariable int id)
    {
        log.info("Request to read hostess: {}", id);
        Hostess input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }
    @GetMapping("/findAll")
    public ResponseEntity <List<Hostess>> findAll (){
        log.info("Request to read all Pilot");
        List <Hostess> hostess = this.service.findAll();
        return ResponseEntity.ok(hostess);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <Hostess> delete (Hostess hostess){
        log.info("Request to delete hostess: {}", hostess);
        this.service.delete(hostess);
        return ResponseEntity.ok(hostess);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Hostess> deleteById(@PathVariable int id){
        log.info("Request to delete hostess: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Hostess> update(@RequestBody Hostess hostess, @PathVariable int id) {
        try {
            Hostess existPilot =service.read(id).orElse(null);
            service.save(hostess);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}