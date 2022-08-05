package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.util.Helper;

public class EmployeeContactFactory {

    public static EmployeeContact CreateEmployeeContact(String employeeId,String conId ){


       if(Helper.nullOrEmpty(employeeId)|| Helper.nullOrEmpty(conId))
           return null;


        return new EmployeeContact.Builder().setEmployeeId(employeeId)
                .setConId(conId)
                .build();

    }

}
