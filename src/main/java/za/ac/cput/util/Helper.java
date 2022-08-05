package za.ac.cput.util;

/*
 * Author : Mahad Hassan
 * Student Number : 219122822
 * Assessment 01 (Term1)
 * */

//import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
public class Helper {

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean nullOrEmpty(String string) {
        return (string == null || string.equals("") || string.isEmpty() ||
                string.equalsIgnoreCase("null"));
    }

//    public static String setEmptyIfNull(String str){
//        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
//        return str;
//    }
//
//    public static void checkStringParam(String paramName, String paramValue){
//        if (isEmptyOrNull(paramValue))
//            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
//    }

}
