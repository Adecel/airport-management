package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee, String> {
    List<Employee> findAll();
}
