package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.EmployeeContact;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeContactRepo extends IRepository<EmployeeContact,String > {

    public Set<EmployeeContact> getAll();
}
