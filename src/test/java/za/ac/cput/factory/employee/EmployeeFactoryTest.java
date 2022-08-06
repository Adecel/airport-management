package za.ac.cput.factory.employee;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.factory.employee.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void testWithSuccess() {
        Employee employee = EmployeeFactory
                .build("123423445",
                "Kimpasti Zaraki",
                "trolls Department",
                "234890");
        System.out.println(employee);
        assertNotNull(employee);
    }

    //minute (34:19,DDD Practical 02)
    @Test
    public void testWithError() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                EmployeeFactory.build(null,
                        "Kimpasti Zaraki",
                        "trolls Department",
                        "234890"));
        String exceptionMessage = exception.getMessage();
        assertSame("employee id is required!", exceptionMessage);
    }


}