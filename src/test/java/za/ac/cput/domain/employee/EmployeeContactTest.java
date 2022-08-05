package za.ac.cput.domain.employee;

import org.junit.jupiter.api.Test;

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