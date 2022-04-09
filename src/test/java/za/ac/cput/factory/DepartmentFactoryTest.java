package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Test
    public void test() {
        Department department = DepartmentFactory.department("234890",
                "trolls Department",
                "transport of lagage");
        assertNotNull(department);

        System.out.println(department);
    }

}