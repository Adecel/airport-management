package za.ac.cput.factory;

import za.ac.cput.domain.entity.PassengerContact;
import za.ac.cput.util.Helper;

public class PassengerContactFactory {

    public static PassengerContact CreatePassengerCont(String passengerId, String conId) {


        if (Helper.nullOrEmpty(passengerId) || Helper.nullOrEmpty(conId))
            return null;


        return  new PassengerContact.Builder().setPassengerId(passengerId)
                .setConId(conId)
                .build();


    }
}
