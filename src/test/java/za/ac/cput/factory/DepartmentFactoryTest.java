package za.ac.cput.factory;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.department.DepartmentFactory;

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