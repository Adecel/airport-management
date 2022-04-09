package za.ac.cput.factory;

import za.ac.cput.domain.entity.Department;
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
