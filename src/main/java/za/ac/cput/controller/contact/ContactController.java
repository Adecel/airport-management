package za.ac.cput.controller.contact;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.service.contact.impl.ContactServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
@Slf4j
@CrossOrigin(origins = "*")
public class ContactController {

    private final ContactServiceImpl contactService;

    @Autowired
    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> save(@Valid @RequestBody Contact contact) {
        log.info("Save request: {}", contact);
        Contact input = contactService.save(contact);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contact2 = this.contactService.findAll();
        return ResponseEntity.ok(contact2);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Contact>> read(@PathVariable int id) {
        log.info("Read request: {}", id);
        Optional<Contact> contact3 = Optional.ofNullable(contactService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(contact3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Contact> delete(@PathVariable Contact contact) {
        log.info("Delete request: {}", contact);
        this.contactService.delete(contact);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        log.info("delete request: {}", id);
        this.contactService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Plane> update(@RequestBody Contact xontact, @PathVariable int id) {
        try {
            Contact existPlane = contactService.read(id).orElse(null);
            contactService.save(xontact);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}