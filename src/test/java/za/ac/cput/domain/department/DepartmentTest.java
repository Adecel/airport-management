package za.ac.cput.domain.department;

import org.junit.jupiter.api.Test;
/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

class DepartmentTest {

    @Test
    public void test() {
        Department department = new Department.Builder().setDepID("34567ffi")
                .setDepName("Mr Shad Bouelo").setDescription("care of employee")
                .build();

        System.out.println(department);
    }

}