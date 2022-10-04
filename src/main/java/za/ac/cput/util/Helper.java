package za.ac.cput.util;

public class Helper {

    public static boolean nullOrEmpty(String string) {
        return (string == null || string.equals("") || string.isEmpty() ||
                string.equalsIgnoreCase("null"));
    }

    public static String setEmptyIfNull(String s) {
        return nullOrEmpty(s) ? "" : s;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if (nullOrEmpty(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
}
