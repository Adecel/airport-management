package za.ac.cput.controller.department;
/*
  Kissimba Nyembo Isaac
  219383448
*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Line;
import za.ac.cput.service.department.impl.LineServiceImpl;

import javax.validation.Valid;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/line")
@CrossOrigin(origins = "*")
public class LineController {

    private final LineServiceImpl lineService;
    @Autowired
    public LineController(LineServiceImpl lineService) {this.lineService = lineService;}

    @PostMapping("/save")
    public ResponseEntity<Line> save(@Valid @RequestBody Line line) {
        log.info("Request to save ticket: {}", line);
        Line input = lineService.save(line);
        return ResponseEntity.ok(input);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Line> read(@PathVariable String id) {
        log.info("Request to read ticket: {}", id);
        Optional<Line> line = Optional.ofNullable(lineService.read(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found")));
        return ResponseEntity.ok(line.get());
    }
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Line>> findAll() {
        log.info("Request to read all tickets");
        Iterable<Line> tickets = lineService.findAll();
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@Valid @RequestBody Line line) {
        log.info("Request to delete ticket: {}", line);
        lineService.delete(line);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        log.info("Request to delete ticket: {}", id);
        lineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
