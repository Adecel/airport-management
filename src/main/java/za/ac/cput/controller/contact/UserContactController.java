package za.ac.cput.controller.contact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.domain.contact.UserContact;
import za.ac.cput.service.contact.impl.UserContactServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-contact")
@Slf4j
@CrossOrigin(origins = "*")
public class UserContactController {

    private final UserContactServiceImpl contactService;
    @Autowired
    public UserContactController(UserContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserContact> save(@Valid @RequestBody UserContact contact){
        log.info("Save request: {}",contact);
        UserContact input = contactService.save(contact);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserContact>> getAll(){
        List<UserContact> contact2 = this.contactService.findAll();
        return ResponseEntity.ok(contact2);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<UserContact>> read(@PathVariable int id){
        log.info("Read request: {}",id);
        Optional<UserContact> contact3 = Optional.ofNullable(contactService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(contact3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Contact> delete(@PathVariable UserContact contact){
        log.info("Delete request: {}",contact);
        this.contactService.delete(contact);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        log.info("delete request: {}", id);
        this.contactService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
