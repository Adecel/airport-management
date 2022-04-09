package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void test() {
        Employee employee = EmployeeFactory.employee("123423445",
                "Kimpasti Zaraki",
                "trolls Department",
                "234890");
        assertNotNull(employee);

        System.out.println(employee);
    }
}