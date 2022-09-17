package za.ac.cput.service.departement.impl;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.department.Department;
import za.ac.cput.factory.department.DepartmentFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentServiceImplTest {


//    @Autowired
    DepartmentServiceImpl departmentService;

    private final Department department = DepartmentFactory
            .build("219197229","rusty@cput.ac.za");
    @Test
    @Order(1)
    void save() {
        Department departmentTest = this.departmentService
                .save(department);
        System.out.println(departmentTest);
        assertNotNull(departmentTest);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Department> readTest =
                this.departmentService.read(department.getDepID());
        assertNotNull(readTest);
        System.out.println(readTest);
    }

    @Test
    @Order(2)
    void delete() {
        this.departmentService.deleteById(department.getDepID());
    }
}