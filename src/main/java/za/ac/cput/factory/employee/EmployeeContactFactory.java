package za.ac.cput.factory.employee;


/*
 * Author : Mahad Hassan
 * Student Number : 219122822
 * Capstone Project
 * Class: EmployeeContact.java
 * */
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.util.Helper;

public class EmployeeContactFactory {

    public static EmployeeContact CreateEmployeeContact(String employeeId,String conId ){

        if(Helper.isEmptyOrNull(employeeId) || Helper.isEmptyOrNull(conId)) {
            return null;
        }
        return new EmployeeContact.Builder()
                .setEmployeeId(employeeId)
                .setConId(conId)
                .build();
    }

}
