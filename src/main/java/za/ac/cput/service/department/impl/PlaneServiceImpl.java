package za.ac.cput.service.department.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.department.Plane;
import za.ac.cput.factory.department.PlaneFactory;
import za.ac.cput.repository.department.PlaneRepository;
import za.ac.cput.service.department.PlaneService;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository repository;
    @Autowired
    public PlaneServiceImpl(PlaneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Plane save(Plane plane) {
        String id = plane.getId();
        String name = plane.getName();
        String capacity = plane.getCapacity();
        String model = plane.getModel();

        Plane saving = PlaneFactory.build(id, name, capacity, model);
        System.out.println("saving" + saving);
        return this.repository.save(saving);
    }

    @Override
    public Optional<Plane> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Plane plane) {
        this.repository.delete(plane);
    }

    @Override
    public void deleteById(String id) {
        Optional<Plane> plane = read(id);
        if (plane.isPresent()) {
            delete(plane.get());
        }
    }

    @Override
    public List<Plane> findAll() {
        return this.repository.findAll();
    }
}
