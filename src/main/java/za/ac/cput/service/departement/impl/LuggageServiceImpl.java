package za.ac.cput.service.departement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.factory.department.LuggageFactory;
import za.ac.cput.repository.department.LuggageRepository;
import za.ac.cput.service.departement.LuggageService;

import java.util.List;
import java.util.Optional;

@Service
public class LuggageServiceImpl implements LuggageService {
    private  final LuggageRepository repository;

    @Autowired
    public LuggageServiceImpl(LuggageRepository repository){
        this.repository  = repository;
    }

    @Override
    public Luggage save(Luggage luggage) {
        String id = luggage.getLuggageID();
        String num = luggage.getLuggageNumber();
        String type = luggage.getLuggageType();

        Luggage insert = LuggageFactory.build(id, num, type);
        System.out.println("insert" + insert);
        return  this.repository.save(insert);
    }

    @Override
    public Optional<Luggage> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(String luggage) {
        this.repository.delete(luggage);

    }

    @Override
    public List<Luggage> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteByID(String id) {
        Optional <Luggage> luggage = read(id);
        if (luggage.isPresent()){
            delete(luggage.get());
        }

    }

    @Override
    public Optional<Luggage> findById(String luggageID) {
        return this.repository.findById(luggageID);
    }
}
