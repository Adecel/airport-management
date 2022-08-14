package za.ac.cput.service.employee.Impl;
/*
 * Author : Mahad Hassan
 * Student Number : 219197229
 * Capstone Project Deliverables
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.repository.employee.EmployeeContactRepository;
import za.ac.cput.service.employee.EmployeeContactService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private final EmployeeContactRepository repository;

    @Autowired
    public EmployeeContactServiceImpl(EmployeeContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeContact save(EmployeeContact employeeContact) {
        return this.repository.save(employeeContact);
    }

    @Override
    public Optional<EmployeeContact> read(String employeeId) {
        return this.repository.findById(employeeId);
    }

    @Override
    public void delete(EmployeeContact employeeContact) {
        this.repository.delete(employeeContact);

    }

    @Override
    public List<EmployeeContact> findAll() {
        return this.repository.findAll();
    }

}