package za.ac.cput.service.departement;

import za.ac.cput.domain.department.Department;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface DepartmentService extends IService<Department, String> {
    List<Department> findById(String depID);
    Employee findDepartmentById(String depID);
    void deleteById(String depID);
}
