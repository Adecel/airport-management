package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import za.ac.cput.domain.department.Department;
import za.ac.cput.util.Helper;

public class DepartmentFactory {

    public static Department build(String depID, String depName, String description){
        Helper.checkStringParam("employeeNumber", depID);
        Helper.checkStringParam("depName", depName);
        Helper.checkStringParam("description", description);

        return new Department.Builder().DepID(depID).DepName(depName).Description(description).build();
    }
}
