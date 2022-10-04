package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.user.UserCategory;
import za.ac.cput.factory.user.UserCategoryFactory;
import za.ac.cput.repository.user.UserCategoryRepository;
import za.ac.cput.service.user.UserCategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {

    private final UserCategoryRepository repository;

    @Autowired
    public UserCategoryServiceImpl(UserCategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public UserCategory save(UserCategory userCategory) {
        String id = userCategory.getId();
        String name = userCategory.getName();
        String description = userCategory.getDescription();

        UserCategory saving = UserCategoryFactory.build(id, name, description);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<UserCategory> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(UserCategory userCategory) {
        this.repository.delete(userCategory);
    }

    @Override
    public void deleteById(String id) {
        Optional<UserCategory> userCategory = read(id);
        if (userCategory.isPresent()) {
            delete(userCategory.get());
        }
    }

    @Override
    public List<UserCategory> findAll() {
        return this.repository.findAll();
    }
}
