package za.ac.cput.repository.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.Department;
import za.ac.cput.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentRepository implements IRepository<Department, String> {

    /*Singletone */
    private final List<Department> departmentList;
    private static DepartmentRepository DEPARTMENT_REPOSITORY;

    private DepartmentRepository(){
        this.departmentList = new ArrayList<>();
    }

    public static DepartmentRepository departmentRepository(){
        if (DEPARTMENT_REPOSITORY == null){
            DEPARTMENT_REPOSITORY = new DepartmentRepository();
        }
        return DEPARTMENT_REPOSITORY;
    }

    @Override
    public Department save(Department department) {
        Optional<Department> read = read(department.getDepID());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.departmentList.add(department);
        return department;
    }

    @Override
    public Optional<Department> read(String depID) {
        return  this.departmentList.stream()
                .filter(a -> a.getDepID().equalsIgnoreCase(depID))
                .findFirst();
    }

    @Override
    public void delete(Department department) {
        this.departmentList.remove(department);
    }

    public List<Department> findAll() {
        return this.departmentList;
    }
}
