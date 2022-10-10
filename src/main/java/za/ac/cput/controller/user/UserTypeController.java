package za.ac.cput.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.service.user.impl.UserTypeServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("airport-management/user-type")
@Slf4j

public class UserTypeController {

    private final UserTypeServiceImpl userTypeService;
    @Autowired
    public UserTypeController(UserTypeServiceImpl userTypeService) {
        this.userTypeService = userTypeService;
    }
    @PostMapping("/save")
    public ResponseEntity<UserType> save(@Valid @RequestBody UserType userType){
        log.info("Save request: {}",userType);
        UserType input = userTypeService.save(userType);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserType>> getAll(){
        List<UserType> userType2 = this.userTypeService.findAll();
        return ResponseEntity.ok(userType2);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<UserType>> read(@PathVariable String id){
        log.info("Read request: {}",id);
        Optional<UserType> userType3 = Optional.ofNullable(userTypeService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(userType3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserType> delete(@PathVariable UserType userType){
        log.info("Delete request: {}",userType);
        this.userTypeService.delete(userType);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("delete request: {}", id);
        this.userTypeService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
