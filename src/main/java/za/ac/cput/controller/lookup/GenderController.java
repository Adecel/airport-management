package za.ac.cput.controller.lookup;
/* ControllerGender.java
 Entity for the ControllerGender
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/09/07
*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.service.lookup.Impl.GenderServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport-management/Gender")
@Slf4j
public class GenderController {

    private final GenderServiceImpl genderService;
    @Autowired
    public GenderController(GenderServiceImpl genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Gender>> getAll(){
        List<Gender> listGender = this.genderService.readAll();
        return ResponseEntity.ok(listGender);
    }

    @GetMapping("/read/{genId}")
    public ResponseEntity<Optional<Gender>> read(@PathVariable String genId){
        log.info("Read request: {}",genId);

        try{
            Optional<Gender> readGender = genderService.read(genId);
            return ResponseEntity.ok(readGender);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Gender> save(@Valid @RequestBody Gender saveGender){
        log.info("Save request: {}",saveGender);

        try{
            Gender genderTemp = genderService.save(saveGender);
            return ResponseEntity.ok(genderTemp);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Gender> delete(@PathVariable Gender gender){
        log.info("Delete request: {}",gender);

        this.genderService.delete(gender);
        return ResponseEntity.noContent().build();
    }


}
