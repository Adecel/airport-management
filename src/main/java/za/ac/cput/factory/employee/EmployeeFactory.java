package za.ac.cput.factory.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.employee.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee build(String employeeName, String depID, String depName){

        String employeeID = Helper.generateID();
        Helper.checkStringParam("employeeName", employeeName);
        Helper.checkStringParam("depID", depID);
        Helper.checkStringParam("depName", depName);
        return new Employee.Builder().EmployeeID(employeeID).EmployeeName(employeeName)
                .DepID(depID).DepName(depName).build();
    }

}
