package za.ac.cput.factory.passenger;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.passenger.Passengers;
import za.ac.cput.util.Helper;

public class PassengersFactory {
    public static Passengers createPassengers(String PassengerID, String PassengerFirstName, String PassengerLastName, String PassengerAge) {
        Helper.checkStringParam("PassengerID", PassengerID);
        Helper.checkStringParam("PassengerFirstName", PassengerFirstName);
        Helper.checkStringParam("PassengerLastName", PassengerLastName);
        Helper.checkStringParam("PassengerAge", PassengerAge);
        return new Passengers.Builder().BuildPassengerAge(PassengerAge)
                .BuildPassengerID(PassengerID)
                .BuildPassengerFirstName(PassengerFirstName)
                .BuildPassengerLastName(PassengerLastName)
                .build();
    }
}