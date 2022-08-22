package za.ac.cput.repository.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public List<Employee> findByEmployeeID(String employeeID);
}
