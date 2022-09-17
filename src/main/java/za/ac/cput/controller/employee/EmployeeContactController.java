package za.ac.cput.controller.employee;
//        * aurthor : Mahad Hassan
//         *
//         * student number (219122822)
//         *
//         * Capstone Project
//         *
//         *
//         * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.service.employee.Impl.EmployeeContactServiceImpl;

import javax.validation.Valid;
@RestController
@RequestMapping("employee-contact")
public class EmployeeContactController {

    private final EmployeeContactServiceImpl service;

    @Autowired
    public EmployeeContactController(EmployeeContactServiceImpl service) {
        this.service = service;
    }


    @PostMapping("save")
    public ResponseEntity<EmployeeContact>save(@Valid @RequestBody EmployeeContact employeeContact){

        EmployeeContact saved = this.service.save(employeeContact);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read")
    public ResponseEntity<EmployeeContact> read(String employeeNumber) {

        EmployeeContact read = service.read(employeeNumber)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(read);

    }
    @DeleteMapping("delete")
    public  ResponseEntity<Void> delete(EmployeeContact employeeContact) {
        this.service.delete(String.valueOf(employeeContact));
        return ResponseEntity.noContent().build();

    }

}


