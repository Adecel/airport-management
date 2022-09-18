package za.ac.cput.service.employee.Impl;

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
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.factory.employee.EmployeeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {


//    @Autowired
    EmployeeServiceImpl  employeeService;

    private final Employee employee = EmployeeFactory
            .build("219197229","rusty@cput.ac.za", "dfgsd");

    @Test
    @Order(1)
    void save() {
        Employee employeeTest = this.employeeService
                .save(employee);
        System.out.println(employeeTest);
        assertNotNull(employeeTest);
    }

    @Test
    @Order(4)
    void read() {
        Optional<Employee> readTest =
                this.employeeService.read(employee.getEmployeeID());
        assertNotNull(readTest);
        System.out.println(readTest);
    }

    @Test
    @Order(5)
    void delete() {
        this.employeeService.deleteById(employee.getEmployeeID());
    }

    @Test
    void findAll() {
    }

    @Test
    void findEmployeeById() {
    }

    @Test
    void deleteById() {
    }
}