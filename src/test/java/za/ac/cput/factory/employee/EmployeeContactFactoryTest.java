package za.ac.cput.factory.employee;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.factory.employee.EmployeeContactFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactFactoryTest {

    @Test
    public void TestEmployeeContact(){

        EmployeeContact employeeContact = new EmployeeContactFactory().CreateEmployeeContact
                ("911","0843990440");
        System.out.println(employeeContact.toString());
    }


}