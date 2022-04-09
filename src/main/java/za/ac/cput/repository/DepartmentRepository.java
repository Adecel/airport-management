package za.ac.cput.repository;


import za.ac.cput.domain.entity.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository implements IDepartmentRepository {

    private static DepartmentRepository repository = null;
    private Set<Department> departmentDB = null;

    private DepartmentRepository() {
        departmentDB = new HashSet<Department>();
    }

    public static DepartmentRepository getRepository() {
        if (repository == null){
            repository = new DepartmentRepository();
        }
        return repository;
    }


    @Override
    public Department create(Department department) {
        boolean success = departmentDB.add(department);
        if (!success){
            return null;
        }
        return department;
    }

    @Override
    public Department read(String depID) {
        for (Department am : departmentDB) {
            if (am.getDepID().equals(depID))
                return am;
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        boolean update = departmentDB.add(department);
        if (!update){
            return null;
        }
        return department;
    }

    @Override
    public boolean delete(String depID) {
        Department departmentToBeDelete = read(depID);
        if(departmentToBeDelete == null) {
            return false;
        }
        departmentDB.remove(departmentToBeDelete);

        return true;
    }

    @Override
    public Set<Department> getAll() {
        return departmentDB;
    }
}
