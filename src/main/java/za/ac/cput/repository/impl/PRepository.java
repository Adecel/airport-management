package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.Passengers;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface PRepository extends IRepository<Passengers, String> {
    //create, read, update delete
    public Set<Passengers> getAll();
}