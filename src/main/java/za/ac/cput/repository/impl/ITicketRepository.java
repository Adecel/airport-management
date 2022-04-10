package za.ac.cput.repository.impl;


//220169136 Dieuci Djate Nsibu
import za.ac.cput.domain.entity.Ticket;
import za.ac.cput.repository.IRepository;


import java.util.Set;

public interface ITicketRepository extends IRepository <Ticket,String>{

    public Set<Ticket> getAll();


}
