package za.ac.cput.util;

/*
 * Author : Adecel Rusty Mabiala
 * Student Number : 219197229
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
