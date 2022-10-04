package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contact.Contact;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.contact.ContactFactory;
import za.ac.cput.factory.user.UserFactory;
import za.ac.cput.repository.user.UserRepository;
import za.ac.cput.service.user.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        String id = user.getId();
        Name name = user.getName();
        Gender gender = user.getGender();

        User saving = UserFactory.build(id, name, gender);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<User> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

    @Override
    public void deleteById(String id) {
        Optional<User> user = read(id);
        if (user.isPresent()) {
            delete(user.get());
        }
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }
}
