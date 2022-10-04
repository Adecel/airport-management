package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.UserType;
import za.ac.cput.factory.user.UserTypeFactory;
import za.ac.cput.repository.user.UserTypeRepository;
import za.ac.cput.service.user.UserTypeService;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository repository;
    @Autowired
    public UserTypeServiceImpl(UserTypeRepository repository){
        this.repository = repository;
    }

    @Override
    public UserType save(UserType userType) {
        String userId = userType.getUserId();
        String userCategoryId = userType.getUserCategoryId();

        UserType saving = UserTypeFactory.build(userId, userCategoryId);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<UserType> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(UserType userType) {
        this.repository.delete(userType);
    }

    @Override
    public void deleteById(String id) {
        Optional<UserType> userType = read(id);
        if (userType.isPresent()) {
            delete(userType.get());
        }
    }

    @Override
    public List<UserType> findAll() {
        return this.repository.findAll();
    }
}
