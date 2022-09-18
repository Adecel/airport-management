package za.ac.cput.controller.department;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.department.Department;
import za.ac.cput.service.departement.DepartmentService;

import java.util.List;


@RestController
@RequestMapping("airport/airportManagement/")
@Slf4j
public class DepartmentController {

    private  final DepartmentService departmentService;

//    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("save")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        log.info("Save request: {}", department);
        Department save = departmentService.save(department);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{depID}")
    public ResponseEntity<Department> read(@PathVariable String depID) {
        log.info("Read request: {}", depID);
        Department department = this.departmentService.read(depID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("delete/{depID}")
    public ResponseEntity<Void> delete(@PathVariable String depID) {
        log.info("Delete request: {}", depID);
        this.departmentService.deleteById(depID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Department>> findDepartmentById(String depID) {
        List<Department> department = (List<Department>) this.departmentService.findDepartmentById(depID);
        return ResponseEntity.ok(department);
    }
}
