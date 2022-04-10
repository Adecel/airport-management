package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.Luggage;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface LRepository extends IRepository<Luggage, String> {

    public Set<Luggage> getAll();
}