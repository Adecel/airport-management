package za.ac.cput.repository.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.Employee;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    void deleteEmployeeById(String employeeID);
    Optional<Employee> findEmployeeById(String employeeID);
}
