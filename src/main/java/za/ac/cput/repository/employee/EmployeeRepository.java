package za.ac.cput.repository.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.Department;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.IRepository;
import za.ac.cput.repository.department.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements IRepository<Employee, String> {

    private final List<Employee> employeeList;
    private static EmployeeRepository EMPLOYEE_REPOSITORY;

    private EmployeeRepository(){
        this.employeeList = new ArrayList<>();
    }

    public static EmployeeRepository employeeRepository() {
        if (EMPLOYEE_REPOSITORY == null) {
            EMPLOYEE_REPOSITORY = new EmployeeRepository();
        }
        return EMPLOYEE_REPOSITORY;
    }


    @Override
    public Employee save(Employee employee) {
        Optional<Employee> read = read(employee.getEmployeeID());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.employeeList.add(employee);
        return employee;
    }

    @Override
    public Optional<Employee> read(String employeeID) {
        return  this.employeeList.stream()
                .filter(a -> a.getEmployeeID().equalsIgnoreCase(employeeID))
                .findFirst();
    }

    @Override
    public void delete(Employee employee) {
        this.employeeList.remove(employee);
    }

    public List<Employee> findAll() {
        return this.employeeList;
    }
}
