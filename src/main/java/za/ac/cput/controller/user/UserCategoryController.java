package za.ac.cput.controller.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.service.user.impl.UserCategoryServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("airport-management/user-category")
@Slf4j
public class UserCategoryController {

    private final UserCategoryServiceImpl userCategoryService;
    @Autowired
    public UserCategoryController(UserCategoryServiceImpl userCategoryService) {
        this.userCategoryService = userCategoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserCategory> save(@Valid @RequestBody UserCategory userCategory){
        log.info("Save request: {}",userCategory);
        UserCategory input = userCategoryService.save(userCategory);
        return ResponseEntity.ok(input);
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<UserCategory>> getAll(){
        List<UserCategory> userCategory2 = this.userCategoryService.findAll();
        return ResponseEntity.ok(userCategory2);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<UserCategory>> read(@PathVariable String id){
        log.info("Read request: {}",id);
        Optional<UserCategory> userCategory3 = Optional.ofNullable(userCategoryService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(userCategory3);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserCategory> delete(@PathVariable UserCategory userCategory){
        log.info("Delete request: {}",userCategory);
        this.userCategoryService.delete(userCategory);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("delete request: {}", id);
        this.userCategoryService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
}
