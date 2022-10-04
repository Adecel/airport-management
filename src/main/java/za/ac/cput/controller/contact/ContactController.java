package za.ac.cput.controller.contact;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.service.contact.impl.ContactServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport-management/contact")
@Slf4j
//the full address is : http://localhost:8080/airport-management/contact/save
//the full address is : http://localhost:8080/airport-management/contact/read/id
public class ContactController {

    private final ContactServiceImpl contactService;
    @Autowired
    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> save(@Valid @RequestBody Contact contact){
        log.info("Save request: {}",contact);
        Contact input = contactService.save(contact);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Contact>> getAll(){
        List<Contact> contact2 = this.contactService.findAll();
        return ResponseEntity.ok(contact2);
    }

//    @GetMapping("read/{id}")
//    public ResponseEntity<Contact> read(@PathVariable String id){
//        log.info("Read request: {}", id);
//        Contact contact = this.contactService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.OK));
//        return  ResponseEntity.ok(contact);
//    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Contact>> read(@PathVariable String id){
        log.info("Read request: {}",id);
        Optional<Contact> contact3 = Optional.ofNullable(contactService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(contact3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Contact> delete(@PathVariable Contact contact){
        log.info("Delete request: {}",contact);
        this.contactService.delete(contact);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("delete request: {}", id);
        this.contactService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
