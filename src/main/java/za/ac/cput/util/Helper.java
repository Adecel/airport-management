package za.ac.cput.util;

/*
 * Author : Mahad Hassan
 * Student Number : 219122822
 * Assessment 01 (Term1)
 * */

import java.util.UUID;

public class Helper {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean nullOrEmpty(String string) {
        return (string == null || string.equals("") || string.isEmpty() ||
                string.equalsIgnoreCase("null"));
    }

}
