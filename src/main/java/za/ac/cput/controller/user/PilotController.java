package za.ac.cput.controller.user;
/*
  Mogamad Tawfeeq Cupido
  216266882
*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.Pilot;
import za.ac.cput.service.user.impl.HostessServiceImpl;
import za.ac.cput.service.user.impl.PilotServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/pilot")
@Slf4j
@CrossOrigin(origins = "*")
public class PilotController {
    private final PilotServiceImpl service;

    @Autowired
    public PilotController (PilotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Pilot> save (@RequestBody Pilot pilot){
        log.info("Request to save pilot: {}", pilot);
        Pilot input = service.save(pilot);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <Pilot> read (@PathVariable int id)
    {
        log.info("Request to read plane: {}", id);
        Pilot input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }



    @GetMapping("/findAll")
    public ResponseEntity <List<Pilot>> findAll (){
        log.info("Request to read all Pilot");
        List <Pilot> pilot = this.service.findAll();
        return ResponseEntity.ok(pilot);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <Pilot> delete (Pilot pilot){
        log.info("Request to delete pilot: {}", pilot);
        this.service.delete(pilot);
        return ResponseEntity.ok(pilot);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Pilot> deleteById(@PathVariable int id){
        log.info("Request to delete Pilot: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Pilot> update(@RequestBody Pilot pilot, @PathVariable int id) {
        try {
            Pilot existPilot =service.read(id).orElse(null);
            service.save(pilot);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}
