package za.ac.cput.controller.employee;
/*Author: Hilary Cassidy Nguepi Nangmo (220346887)
        Date: 2022/08/07
        */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.EmployeeGender;
import za.ac.cput.service.employee.Impl.EmployeeGenderServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport-management/EmployeeGender")
@Slf4j
public class EmployeeGenderController {

    private final EmployeeGenderServiceImpl empGenderService;
    @Autowired
    public EmployeeGenderController(EmployeeGenderServiceImpl empGenderService) {
        this.empGenderService = empGenderService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<EmployeeGender>> getAll(){
        List<EmployeeGender> listEmpGender = this.empGenderService.readAll();
        return ResponseEntity.ok(listEmpGender);
    }

    @GetMapping("/read/{genId}")
    public ResponseEntity<Optional<EmployeeGender>> read(@PathVariable String genId){
        log.info("Read request: {}",genId);
        Optional<EmployeeGender> readEmpGender = Optional.ofNullable(empGenderService.read(genId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(readEmpGender);


    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeGender> save(@Valid @RequestBody EmployeeGender saveEmpGender){
        log.info("Save request: {}",saveEmpGender);


        EmployeeGender empGenderTemp = empGenderService.save(saveEmpGender);
        return ResponseEntity.ok(empGenderTemp);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<EmployeeGender> delete(@PathVariable String empGender){
        log.info("Delete request: {}",empGender);

        this.empGenderService.delete(empGender);
        return ResponseEntity.noContent().build();
    }
}
