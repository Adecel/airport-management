package za.ac.cput.factory.passenger;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.passenger.Passengers;
import za.ac.cput.util.Helper;

public class PassengersFactory {
    public static Passengers createPassengers(String PassengerID, String PassengerFirstName, String PassengerLastName, String PassengerAge){
        if (Helper.nullOrEmpty(PassengerID )|| Helper.nullOrEmpty(PassengerFirstName) || Helper.nullOrEmpty(PassengerLastName) || Helper.nullOrEmpty(PassengerAge))
            return null;
        return new Passengers.Builder().setPassengerID(PassengerID)
                .setPassengerFirstName(PassengerFirstName)
                .setPassengerLastName(PassengerLastName)
                .setPassengerAge(PassengerAge)
                .build();
    }
}