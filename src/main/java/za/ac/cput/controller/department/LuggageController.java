package za.ac.cput.controller.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.service.departement.LuggageService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Adp/luggage/")
@Slf4j
public class LuggageController {
        private final LuggageService luggageService;
        @Autowired public LuggageController(LuggageService luggageService){this.luggageService =luggageService;}
    @PostMapping("save")
    public ResponseEntity<Luggage> save(@Valid @RequestBody Luggage luggage) throws Exception {
          log.info("save request : {}", luggage);
          Luggage save = luggageService.save(luggage);
          return ResponseEntity.ok(save);
    }
    private Optional<Luggage> getById(String Id){return this.luggageService.read(Id);}
    @GetMapping("read/{id}")
    public ResponseEntity<Luggage> read(@PathVariable String id){
            log.info("Read request: {}", id);
            Luggage luggage = this.luggageService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.OK));
            return  ResponseEntity.ok(luggage);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
            log.info("delete request: {}", id);
            this.luggageService.deleteByID(id);
            return  ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public  ResponseEntity<List<Luggage>> findAll(){
      List<Luggage> luggages = this.luggageService.findAll();
      return  ResponseEntity.ok(luggages);
    }

}
