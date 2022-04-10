package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.EmployeeContact;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeContactFactoryTest {

    @Test
    public void test(){

        EmployeeContact employeeContact = new EmployeeContactFactory().CreateEmployeeContact
                ("911","0843990440");

        System.out.println(employeeContact.toString());

    }

}