package za.ac.cput.repository.employee;

import za.ac.cput.domain.employee.EmployeeContact;

import java.util.HashSet;
import java.util.Set;

public class EmployeeContactRepository implements IEmployeeContactRepo {

    private  static  EmployeeContactRepository repository = null;
    private Set<EmployeeContact> employeeConDb = null;



    // private cons

    private EmployeeContactRepository(){
        employeeConDb = new HashSet<EmployeeContact>();

    }

    public static EmployeeContactRepository getRepository(){

        if(repository==null){

            repository = new EmployeeContactRepository();
        }
        return repository;
    }



    @Override
    public EmployeeContact create(EmployeeContact employeeContact) {

        boolean success = employeeConDb.add(employeeContact);
        if(!success)
            return null;
        return employeeContact;


    }

    @Override
    public EmployeeContact read(String employeeId) {
        for(EmployeeContact e :employeeConDb) {
            if (e.getEmployeeId().equals(employeeId))
                return e;
        }
        return null;
    }

    @Override
    public EmployeeContact update(EmployeeContact employeeContact) {

        EmployeeContact oldEmpl = read(employeeContact.getEmployeeId());

        if(oldEmpl!=null) {

            employeeConDb.remove(oldEmpl);
            employeeConDb.add(employeeContact);
            return employeeContact;
        }
        return null;

    }

    @Override
    public boolean delete(String employeeId) {

        EmployeeContact employeeConToDelete = read(employeeId);
        if (employeeConToDelete == null)
            return false;
        employeeConDb.remove(employeeConToDelete);

        return true;


    }

    @Override
    public Set<EmployeeContact> getAll() {
        return employeeConDb;
    }
}
