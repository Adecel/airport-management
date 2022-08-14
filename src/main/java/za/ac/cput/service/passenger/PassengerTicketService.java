package za.ac.cput.service.passenger;

import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.service.IService;

public interface PassengerTicketService  extends IService<PassengerTicket, String> {
    PassengerTicket FindByTicketID(String ticketID);
//    boolean delete(String ticketID);
}
