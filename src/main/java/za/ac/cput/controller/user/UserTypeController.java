package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.service.user.impl.UserTypeServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user-type")
@Slf4j
@CrossOrigin(origins = "*")
public class UserTypeController {

    private final UserTypeServiceImpl service;

    @Autowired
    public UserTypeController (UserTypeServiceImpl service) {this.service = service;}

    @PostMapping("/save")
    public ResponseEntity<UserType> save (@RequestBody UserType userType){
        log.info("Request to save plane: {}", userType);
        UserType input = service.save(userType);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <UserType> read (@PathVariable String id)
    {
        log.info("Request to read plane: {}", id);
        UserType input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/findAll")
    public ResponseEntity <List<UserType>> findAll (){
        log.info("Request to read all planes");
        List <UserType> userType = this.service.findAll();
        return ResponseEntity.ok(userType);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <UserType> delete (UserType userType){
        log.info("Request to delete plane: {}", userType);
        this.service.delete(userType);
        return ResponseEntity.ok(userType);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <UserType> deleteById(@PathVariable String id){
        log.info("Request to delete plane: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserType> update(@RequestBody UserType userType, @PathVariable String id) {
        try {
            UserType existPlane =service.read(id).orElse(null);
            service.save(userType);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }}

