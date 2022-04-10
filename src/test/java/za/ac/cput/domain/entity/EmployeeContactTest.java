package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactTest {

    @Test
    public void test(){

        EmployeeContact employeeContact = new EmployeeContact.Builder().setEmployeeId("991")
                .setConId("7773")
                .build();
        System.out.println(employeeContact);


        EmployeeContact employeeContact2 = new EmployeeContact.Builder().setEmployeeId("991")
                .setConId("7773")
                .build();
        System.out.println(employeeContact2);


    }

}