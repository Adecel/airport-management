package za.ac.cput.factory.passenger;

/*
 * Author : Mahad Hassan
 * Student Number : 219122822
 * Capstone Project
 * Class : PassengerContact.java
 * */
import za.ac.cput.domain.passenger.PassengerContact;
import za.ac.cput.util.Helper;

public class PassengerContactFactory {

    public static PassengerContact CreatePassengerCont(String passengerId, String conId) {


        if (Helper.isEmptyOrNull(passengerId) || Helper.isEmptyOrNull(conId))
            return null;


        return  new PassengerContact.Builder().setPassengerId(passengerId)
                .setConId(conId)
                .build();


    }
}
