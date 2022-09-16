package za.ac.cput.service.passenger;

import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.service.IService;

import java.util.List;

public interface PassengerTicketService  extends IService<PassengerTicket, String> {
    PassengerTicket FindByTicketID(String ticketID);
    List<PassengerTicket> findAll();
//    boolean delete(String ticketID);
}
