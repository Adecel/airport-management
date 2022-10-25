package za.ac.cput.controller.contact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.service.contact.impl.ContactTypeServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact-type")
@Slf4j
@CrossOrigin(origins = "*")
public class ContactTypeController {
    private final ContactTypeServiceImpl contactTypeService;
    @Autowired
    public ContactTypeController(ContactTypeServiceImpl contactService) {
        this.contactTypeService = contactService;
    }

    @PostMapping("/save")
    public ResponseEntity<ContactType> save(@Valid @RequestBody ContactType contactType){
        log.info("Save request: {}",contactType);
        ContactType input = contactTypeService.save(contactType);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ContactType>> getAll(){
        List<ContactType> contact2 = this.contactTypeService.findAll();
        return ResponseEntity.ok(contact2);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<ContactType>> read(@PathVariable String id){
        log.info("Read request: {}",id);
        Optional<ContactType> contact3 = Optional.ofNullable(contactTypeService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(contact3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ContactType> delete(@PathVariable ContactType contact){
        log.info("Delete request: {}",contact);
        this.contactTypeService.delete(contact);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("delete request: {}", id);
        this.contactTypeService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}

