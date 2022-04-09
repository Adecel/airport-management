package za.ac.cput.factory;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee employee(String employeeID, String employeeName, String depID, String depName){

        if (Helper.nullOrEmpty(employeeID))
            return null;

        if (Helper.nullOrEmpty(employeeName))
            return null;

        if (Helper.nullOrEmpty(depID))
            return null;

        if (Helper.nullOrEmpty(depName))
            return null;

        return new Employee.Builder().setEmployeeID(employeeID)
                .setEmployeeName(employeeName).setDepID(depID).setDepName(depName)
                .build();
    }
}
