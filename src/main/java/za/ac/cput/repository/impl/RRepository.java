package za.ac.cput.repository.impl;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.entity.RunWay;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface RRepository extends IRepository<RunWay, String> {
    //create, read, update delete
    public Set<RunWay> getAll();
}

