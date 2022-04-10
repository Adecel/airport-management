package za.ac.cput.repository.impl;


import za.ac.cput.domain.entity.PassengerTicket;
import za.ac.cput.repository.IRepository;




import java.util.Set;

public interface IPassengerTicketRepository extends IRepository <PassengerTicket,String>{
    public Set<PassengerTicket> getAll();
}
