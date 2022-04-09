package za.ac.cput.repository;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.Employee;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee, String>{
    public Set<Employee> getAll();
}
