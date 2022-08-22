package za.ac.cput.factory.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee build(String employeeID, String employeeName, String depID, String depName){

        // String employeeID = Helper.generateID();

        if (employeeID == null || employeeID.isEmpty()){
            throw new IllegalArgumentException("employee id is required!");
        }
        if (employeeName == null || employeeName.isEmpty()){
            throw new IllegalArgumentException("employee Name is required!");
        }
        if (depID == null || depID.isEmpty()){
            throw new IllegalArgumentException("dep id is required!");
        }
        if (depName == null || depName.isEmpty()){
            throw new IllegalArgumentException("dep Name is required!");
        }
        return new Employee.Builder().EmployeeID(employeeID).EmployeeName(employeeName)
                .DepID(depID).DepName(depName).build();
    }

}
