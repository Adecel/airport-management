package za.ac.cput.factory.employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.employee.EmployeeContactFactory;

class EmployeeContactFactoryTest {

    @Test
    public void test(){

        EmployeeContact employeeContact = new EmployeeContactFactory().CreateEmployeeContact
                ("911","0843990440");

        System.out.println(employeeContact.toString());

    }

}