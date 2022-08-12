package za.ac.cput.repository.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.department.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
