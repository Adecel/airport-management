package za.ac.cput.service.contact.impl;
/*
  Hilary Cassidy Nguepi Nangmo
  220346887
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.factory.contact.ContactFactory;
import za.ac.cput.repository.contact.ContactRepository;
import za.ac.cput.service.contact.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactServiceImpl(ContactRepository repository){
        this.repository = repository;
    }

    @Override
    public Contact save(Contact contact) {
        int id = contact.getId();
        String cont = contact.getContact();
        String description = contact.getDescription();

        Contact saving = ContactFactory.build(id, cont, description);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Contact> read(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Contact contact) {
        this.repository.delete(contact);
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Contact> contact = read(id);
        if (contact.isPresent()) {
            delete(contact.get());
        }
//        this.repository.deleteById(id);
    }

    @Override
    public List<Contact> findAll() {
        return this.repository.findAll();
    }
}
