package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactRepository extends IRepository<Contact,String> {
    public Set<Contact> getAll();


}
