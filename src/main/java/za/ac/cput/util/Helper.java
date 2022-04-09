package za.ac.cput.util;

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
