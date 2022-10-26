package za.ac.cput.controller.user;
/*
  Adecel Rusty Mabiala
  219197229
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.service.user.impl.UserCategoryServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user-category")
@Slf4j
@CrossOrigin(origins = "*")
public class UserCategoryController {

    private final UserCategoryServiceImpl service;

    @Autowired
    public UserCategoryController (UserCategoryServiceImpl service) {this.service = service;}

    @PostMapping("/save")
    public ResponseEntity<UserCategory> save (@RequestBody UserCategory userCategory){
        log.info("Request to save plane: {}", userCategory);
        UserCategory input = service.save(userCategory);
        return ResponseEntity.ok(input);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity <UserCategory> read (@PathVariable String id)
    {
        log.info("Request to read plane: {}", id);
        UserCategory input = service.read(id).orElse(null);
        return ResponseEntity.ok(input);
    }



    @GetMapping("/findAll")
    public ResponseEntity <List<UserCategory>> findAll (){
        log.info("Request to read all planes");
        List <UserCategory> userCategory = this.service.findAll();
        return ResponseEntity.ok(userCategory);
    }
    @DeleteMapping("/delete")
    public ResponseEntity <UserCategory> delete (UserCategory userCategory){
        log.info("Request to delete plane: {}", userCategory);
        this.service.delete(userCategory);
        return ResponseEntity.ok(userCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <UserCategory> deleteById(@PathVariable String id){
        log.info("Request to delete plane: {}", id);
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserCategory> update(@RequestBody UserCategory userCategory, @PathVariable String id) {
        try {
            UserCategory existPlane =service.read(id).orElse(null);
            service.save(userCategory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }}
