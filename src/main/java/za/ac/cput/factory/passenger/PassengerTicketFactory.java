package za.ac.cput.factory.passenger;
//220169136 DIEUCI DJATE NSIBU

import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.util.Helper;

public class PassengerTicketFactory {
    public static PassengerTicket createPassengerTicket(String passengerID,String ticketID,int price,String luggageID) {
        return new PassengerTicket.Builder().setPassengerID(passengerID).setTicketID(ticketID).setPrice(price).setLuggageID(luggageID).build();
    }
}
