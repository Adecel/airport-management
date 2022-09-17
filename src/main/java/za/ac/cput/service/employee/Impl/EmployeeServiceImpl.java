package za.ac.cput.service.employee.Impl;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.service.employee.EmployeeService;
import za.ac.cput.util.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee){
        return repository.save(employee);
    }

    @Override
    public Optional<Employee> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(String employee) {

    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployeeById(String employeeID) {
        return repository.findEmployeeById(employeeID)
                .orElseThrow(() -> new UserNotFoundException("This ID"
                        + employeeID + "was not found"));
    }

    @Override
    public void deleteById(String employeeID) {
        repository.deleteEmployeeById(employeeID);
    }
}
