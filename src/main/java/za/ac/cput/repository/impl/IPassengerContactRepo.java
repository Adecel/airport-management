package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.PassengerContact;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IPassengerContactRepo extends IRepository<PassengerContact,String> {
    public Set<PassengerContact> getAll();
}
