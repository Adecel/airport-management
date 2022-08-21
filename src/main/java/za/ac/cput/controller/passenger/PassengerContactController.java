package za.ac.cput.controller.passenger;
//        * aurthor : Mahad Hassan
//         *
//         * student number (219122822)
//         *
//         * Capstone Project
//         *
//         *
//         * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.service.passenger.Impl.PassengerContactServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("passenger-contact")
public class PassengerContactController {

    private final PassengerContactServiceImpl service;

    @Autowired
    public PassengerContactController(PassengerContactServiceImpl service) {
        this.service = service;
    }


    @PostMapping("save")
    public ResponseEntity<PassengerContact> save(@Valid @RequestBody PassengerContact passengerContact){
        PassengerContact saved = this.service.save(passengerContact);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read")
    public ResponseEntity<PassengerContact> read(String passengerId) {

        PassengerContact read = service.read(passengerId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(read);

    }
    @DeleteMapping("delete")
    public  ResponseEntity<Void> delete(PassengerContact passengerContact) {
        this.service.delete(passengerContact);
        return ResponseEntity.noContent().build();

    }

}
