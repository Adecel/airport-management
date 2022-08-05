package za.ac.cput.domain.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    public void test() {
        Employee employee = new Employee.Builder().setEmployeeID("23456")
                .setEmployeeName("Mr James, Patrick").setDepID("65432")
                .setDepName("trolling").build();

        System.out.println(employee);
    }

}