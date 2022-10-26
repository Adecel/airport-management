package za.ac.cput.controller.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.service.department.impl.PlaneServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/plane")
@Slf4j
@CrossOrigin(origins = "*")
public class PlaneController {
    private final PlaneServiceImpl planeService;

    @Autowired
    public PlaneController(PlaneServiceImpl planeService) {this.planeService = planeService;}

    @PostMapping("/save")
    public ResponseEntity <Plane> save (@RequestBody Plane plane){
        log.info("Request to save plane: {}", plane);
        Plane input = planeService.save(plane);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <Plane> read (@PathVariable int id){
        log.info("Request to read plane: {}", id);
        Plane input = planeService.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }



    @GetMapping("/findAll")
    public ResponseEntity <List<Plane>> findAll (){
        log.info("Request to read all planes");
        List <Plane> plane = this.planeService.findAll();
        return ResponseEntity.ok(plane);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <Plane> delete (Plane plane){
        log.info("Request to delete plane: {}", plane);
        this.planeService.delete(plane);
        return ResponseEntity.ok(plane);
    }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity <Plane> deleteById(@PathVariable int id){
        log.info("Request to delete plane: {}", id);
        this.planeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Plane> update(@RequestBody Plane plane, @PathVariable int id) {
        try {
            Plane existPlane = planeService.read(id).orElse(null);
            planeService.save(plane);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}
