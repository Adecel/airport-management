package za.ac.cput.factory.passenger;
//220169136 DIEUCI DJATE NSIBU

import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.util.Helper;

public class PassengerTicketFactory {
    public static PassengerTicket createPassengerTicket(int price){
        String ticketID = Helper.generateID();
        String passengerID = Helper.generateID();
        String luggageID = Helper.generateID();
        if (Helper.isEmptyOrNull(ticketID) || Helper.isEmptyOrNull(passengerID) || Helper.isEmptyOrNull(luggageID))
            throw new IllegalArgumentException();
        return new PassengerTicket.Builder().setTicketID(ticketID).setPrice(price).build();

    }
}
