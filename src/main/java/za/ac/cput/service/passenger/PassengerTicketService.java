package za.ac.cput.service.passenger;

import za.ac.cput.domain.passenger.PassengerTicket;
import za.ac.cput.service.IService;

import java.util.List;

public interface PassengerTicketService  extends IService<PassengerTicket, String> {
    List<PassengerTicket> findAll();
    PassengerTicket findByPassengerID(String passengerID);
    void deleteById(String passengerID);
}
