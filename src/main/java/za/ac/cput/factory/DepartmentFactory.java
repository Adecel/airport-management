package za.ac.cput.factory;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
 * Assessment 01 (Term1)
 * */

import za.ac.cput.domain.entity.Department;
import za.ac.cput.util.Helper;

public class DepartmentFactory {

    public static Department department(String depID, String depName, String description){

        if (Helper.nullOrEmpty(depID) || Helper.nullOrEmpty(depName) || Helper.nullOrEmpty(description)) {
            return null;
        }

        return new Department.Builder().setDepID(depID)
                .setDepName(depName).setDescription(description)
                .build();
    }
}
