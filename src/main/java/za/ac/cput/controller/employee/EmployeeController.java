package za.ac.cput.controller.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.employee.EmployeeService;


import java.util.List;


@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{employeeID}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("employeeID") String employeeID) {
        Employee employees = employeeService.findEmployeeById(employeeID);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) throws Exception {
//        log.info("Save request: {}", employee);
        Employee save1 = employeeService.save(employee);
        return new ResponseEntity<>(save1, HttpStatus.CREATED);
    }

//    @PostMapping("/update")
//    public ResponseEntity<Employee> update(@RequestBody Employee employee) throws Exception {
//        Employee save2 = employeeService.update(employee);
//        return new ResponseEntity<>(save2, HttpStatus.OK);
//    }

    @GetMapping("read/{employeeID}")
    public ResponseEntity<Employee> read(@PathVariable String employeeID) {
        log.info("Read request: {}", employeeID);
        Employee employee = this.employeeService.read(employeeID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete/{employeeID}")
    public ResponseEntity<Void> delete(@PathVariable String employeeID) {
        log.info("Delete request: {}", employeeID);
        this.employeeService.deleteById(employeeID);
//        return ResponseEntity.noContent().build();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

