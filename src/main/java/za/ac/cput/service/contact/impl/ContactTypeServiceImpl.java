package za.ac.cput.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.factory.contact.ContactTypeFactory;
import za.ac.cput.repository.contact.ContactTypeRepository;
import za.ac.cput.service.contact.ContactTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactTypeServiceImpl implements ContactTypeService {

    private final ContactTypeRepository repository;

    @Autowired
    public ContactTypeServiceImpl(ContactTypeRepository repository){
        this.repository = repository;
    }

    @Override
    public ContactType save(ContactType contactType) {
        String id = contactType.getId();
        String email = contactType.getEmail();
        String phoneNumber = contactType.getPhoneNumber();
        String description = contactType.getDescription();

        ContactType saving = ContactTypeFactory.build(id, email, phoneNumber, description);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<ContactType> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(ContactType contactType) {
        this.repository.delete(contactType);
    }

    @Override
    public void deleteById(String id) {
        Optional<ContactType> contactType = read(id);
        if (contactType.isPresent()) {
            delete(contactType.get());
        }
    }

    @Override
    public List<ContactType> findAll() {
        return this.repository.findAll();
    }
}
