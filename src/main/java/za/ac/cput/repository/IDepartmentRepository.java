package za.ac.cput.repository;

import za.ac.cput.domain.entity.Department;

import java.util.Set;

public interface IDepartmentRepository extends IRepository<Department, String>{
    public Set<Department> getAll();
}
