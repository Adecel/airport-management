package za.ac.cput.service.employee.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) throws Exception {
        return null;
    }

    @Override
    public Optional<Employee> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
