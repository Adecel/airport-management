package za.ac.cput.factory.department;


import za.ac.cput.domain.department.Ticket;
import za.ac.cput.util.Helper;

public class TicketFactory {

    public static Ticket build(String id, String userId, String flightLineId,
                               String seatNumber, String price, String luggage) {

        Helper.checkStringParam("TicketId", id);
        Helper.checkStringParam("userId", userId);
        Helper.checkStringParam("flightLineId", flightLineId);
        Helper.checkStringParam("seatNumber", seatNumber);
        Helper.checkStringParam("price", price);
        Helper.checkStringParam("luggage", luggage);

        return Ticket.builder().id(id).userId(userId).flightLineId(flightLineId)
                .seatNumber(seatNumber).price(price).price(price).luggage(luggage)
                .build();
    }
}
