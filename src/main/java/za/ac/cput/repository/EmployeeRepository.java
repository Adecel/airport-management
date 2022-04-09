package za.ac.cput.repository;

import za.ac.cput.domain.entity.Department;
import za.ac.cput.domain.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {

    private static EmployeeRepository repository = null;
    private Set<Employee> employeeDB = null;

    private EmployeeRepository() {
        employeeDB = new HashSet<Employee>();
    }

    public static EmployeeRepository getRepository() {
        if (repository == null){
            repository = new EmployeeRepository();
        }
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeDB.add(employee);
        if (!success){
            return null;
        }
        return employee;
    }

    @Override
    public Employee read(String employeeID) {
        for (Employee am : employeeDB) {
            if (am.getEmployeeID().equals(employeeID))
                return am;
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        boolean update = employeeDB.add(employee);
        if (!update){
            return null;
        }
        return employee;
    }

    @Override
    public boolean delete(String employeeID) {
        Employee employeeToBeDelete = read(employeeID);
        if(employeeToBeDelete == null) {
            return false;
        }
        employeeDB.remove(employeeToBeDelete);

        return true;
    }

    @Override
    public Set<Employee> getAll() {
        return employeeDB;
    }
}
