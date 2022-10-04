package za.ac.cput.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.UserContact;
import za.ac.cput.factory.contact.UserContactFactory;
import za.ac.cput.repository.contact.UserContactRepository;
import za.ac.cput.service.contact.UserContactService;

import java.util.List;
import java.util.Optional;

@Service
public class UserContactServiceImpl implements UserContactService {

    private final UserContactRepository repository;

    @Autowired
    public UserContactServiceImpl(UserContactRepository repository){
        this.repository = repository;
    }

    @Override
    public UserContact save(UserContact userContact) {
        String userId = userContact.getUserId();
        String contactTypeId = userContact.getContactTypeId();
        String contactId = userContact.getContactId();
        String date = userContact.getDate();

        UserContact saving = UserContactFactory.build(userId, contactTypeId, contactId, date);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<UserContact> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(UserContact userContact) {
//        Optional<UserContact> userContact1 = read(userContact);
//        userContact.ifPrecent(userContact2 -> repository.delete(userContact2);
        this.repository.delete(userContact);
    }

    @Override
    public void deleteById(String id) {
        Optional<UserContact> userContact = read(id);
        if (userContact.isPresent()) {
            delete(userContact.get());
        }
    }

    @Override
    public List<UserContact> findAll() {
        return this.repository.findAll();
    }
}
