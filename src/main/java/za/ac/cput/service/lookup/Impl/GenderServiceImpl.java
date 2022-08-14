package za.ac.cput.service.lookup.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.repository.lookup.GenderRepository;
import za.ac.cput.service.lookup.GenderService;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {
    private final GenderRepository repository;
    @Override
    public Gender save(Gender gender) {
        return this.repository.save(gender);
    }

    @Override
    public Optional<Gender> read(String s) {

        return this.repository.findById(s);
    }

    @Override
    public void delete(Gender gender) {

        this.repository.delete(gender);
    }
}
