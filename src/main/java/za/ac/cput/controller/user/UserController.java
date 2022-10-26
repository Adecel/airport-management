package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.User;
import za.ac.cput.service.user.impl.UserServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*")
public class UserController {

    private final UserServiceImpl service;

    @Autowired
    public UserController (UserServiceImpl service) {this.service = service;}

    @PostMapping("/save")
    public ResponseEntity<User> save (@RequestBody User user){
        log.info("Request to save plane: {}", user);
        User input = service.save(user);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <User> read (@PathVariable int id)
    {
        log.info("Request to read plane: {}", id);
        User input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }



    @GetMapping("/findAll")
    public ResponseEntity <List<User>> findAll (){
        log.info("Request to read all planes");
        List <User> user = this.service.findAll();
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <User> delete (User user){
        log.info("Request to delete plane: {}", user);
        this.service.delete(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <User> deleteById(@PathVariable int id){
        log.info("Request to delete plane: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable int id) {
        try {
            User existPlane =service.read(id).orElse(null);
            service.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}

