package za.ac.cput.service.departement.impl;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Department;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.repository.department.DepartmentRepository;
import za.ac.cput.service.departement.DepartmentService;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository){
        this.repository = repository;
    }

//    private final DepartmentRepository repository;
//    private static DepartmentService SERVICE;
//
//    private DepartmentServiceImpl() {
//        this.repository = DepartmentServiceImpl.SERVICE;
//    }
//
//    public static DepartmentService getService() {
//        if (SERVICE == null)
//            SERVICE = new DepartmentServiceImpl();
//        return SERVICE;
//    }

    @Override
    public Department save(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Optional<Department> read(String s) {
//        return this.repository.read(s);
        return Optional.empty();
    }

    @Override
    public void delete(String department) {
        this.repository.delete(department);
    }

    @Override
    public List<Department> findById(String depID) {
        return null;
    }

    @Override
    public Employee findDepartmentById(String depID) {
        return null;
    }

    @Override
    public void deleteById(String depID) {

    }

}
