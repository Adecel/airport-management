package za.ac.cput.controller.passenger;
/*Author: Hilary Cassidy Nguepi Nangmo (220346887)
        Date: 2022/08/07
        */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.passenger.PassengerGender;
import za.ac.cput.service.passenger.Impl.PassengerGenderServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport-management/PassengerGender")
@Slf4j
public class PassengerGenderController {

    private final PassengerGenderServiceImpl passengerGenderService;
    @Autowired
    public PassengerGenderController(PassengerGenderServiceImpl passGender) {
        this.passengerGenderService = passGender;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PassengerGender>> getAll(){
        List<PassengerGender> listPassGender = this.passengerGenderService.readAll();
        return ResponseEntity.ok(listPassGender);
    }

    @GetMapping("/read/{genId}")
    public ResponseEntity<Optional<PassengerGender>> read(@PathVariable String genId){
        log.info("Read request: {}",genId);
        Optional<PassengerGender> readPassGender = Optional.ofNullable(passengerGenderService.read(genId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(readPassGender);


    }

    @PostMapping("/save")
    public ResponseEntity<PassengerGender> save(@Valid @RequestBody PassengerGender savePassGender){
        log.info("Save request: {}",savePassGender);


        PassengerGender passGenderTemp = passengerGenderService.save(savePassGender);
        return ResponseEntity.ok(passGenderTemp);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<PassengerGender> delete(@PathVariable PassengerGender passGender){
        log.info("Delete request: {}",passGender);

        this.passengerGenderService.delete(passGender);
        return ResponseEntity.noContent().build();
    }
}
