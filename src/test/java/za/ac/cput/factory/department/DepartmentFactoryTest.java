package za.ac.cput.factory.department;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Department;
import za.ac.cput.factory.department.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Test
    public void testWithSuccess() {
        Department department = DepartmentFactory.build("234890",
                "trolls Department",
                "transport of lagage");
        System.out.println(department);
        assertNotNull(department);
    }

    @Test
    public void testWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
                DepartmentFactory.build(null,
                        "trolls Department",
                        "transport of lagage"));
        System.out.println(exception.getMessage());
        assertFalse(exception.getMessage().contains("depID"));
    }

//    @Test
//    public void testWithErrors(){
//        Exception exception = assertThrows(IllegalArgumentException.class, ()->
//                DepartmentFactory.build(null,
//                        "trolls Department",
//                        "transport of lagage"));
//        String exceptionMessage = exception.getMessage();
//        assertSame("depID is required!", exceptionMessage);
//    }

}