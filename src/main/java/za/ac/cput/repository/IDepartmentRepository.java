package za.ac.cput.repository;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.Department;

import java.util.Set;

public interface IDepartmentRepository extends IRepository<Department, String>{
    public Set<Department> getAll();
}
