package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    public void test() {
        Department department = new Department.Builder().setDepID("34567ffi")
                .setDepName("Mr Shad Bouelo").setDescription("care of employee")
                .build();

        System.out.println(department);
    }

}