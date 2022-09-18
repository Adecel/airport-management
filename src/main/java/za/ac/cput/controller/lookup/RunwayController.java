package za.ac.cput.controller.lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.RunWay;
import za.ac.cput.service.lookup.RunWayService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Adp/runway/")
@Slf4j
public class RunwayController {
    private final RunWayService runWayService;
    @Autowired public RunwayController(RunWayService runWayService){this.runWayService = runWayService;}
    @PostMapping("save")
    public ResponseEntity<RunWay> save(@Valid @RequestBody RunWay runWay) throws Exception {
        log.info("save request : {}", runWay);
        RunWay save = runWayService.save(runWay);
        return ResponseEntity.ok(save);
    }
    private Optional<RunWay> getById(String Id){return this.runWayService.read(Id);}
    @GetMapping("read/{id}")
    public ResponseEntity<RunWay> read(@PathVariable String id){
        log.info("Read request: {}", id);
        RunWay runWay = this.runWayService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.OK));
        return  ResponseEntity.ok(runWay);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("delete request: {}", id);
        this.runWayService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<RunWay>> findAll(){
        List<RunWay> runWays = this.runWayService.findAll();
        return  ResponseEntity.ok(runWays);
    }
}
