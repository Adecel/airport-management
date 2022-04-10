package za.ac.cput.repository.impl;

//220169136 Dieuci Djate Nsibu

import za.ac.cput.domain.entity.Flight;
import za.ac.cput.repository.IRepository;


import java.util.Set;


public interface IFlightRepository extends IRepository<Flight,String> {
    public Set<Flight> getAll();
}

