package za.ac.cput.factory;

import za.ac.cput.domain.entity.EmployeeContact;
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
