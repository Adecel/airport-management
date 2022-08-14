package za.ac.cput.service.lookup.Impl;

/*
 * Author : Mahad Hassan
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Contact;
import za.ac.cput.repository.lookup.ContactRepository;
import za.ac.cput.service.lookup.ContactService;

import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

   @Autowired
   public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact save(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Optional<Contact> read(String id) {
        return Optional.of(this.repository.getById(id));
    }

    @Override
    public void delete(Contact contact) {
        this.repository.delete(contact);

    }

    @Override
    public List<Contact> findAll() {
        return this.repository.findAll();
    }
}
