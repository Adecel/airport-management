package za.ac.cput.service.employee.Impl;
/*Author: Hilary Cassidy Nguepi Nangmo (220346887)
        Date: 2022/08/07
        */
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.EmployeeGender;
import za.ac.cput.repository.employee.EmployeeGenderRepository;
import za.ac.cput.service.employee.EmployeeGenderService;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EmployeeGenderServiceImpl implements EmployeeGenderService{

    private final EmployeeGenderRepository repository;
    @Override
    public EmployeeGender save(EmployeeGender employeeGender){
        return  this.repository.save(employeeGender);
    }

    @Override
    public Optional<EmployeeGender> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(String employeeGender) {
       this.repository.delete(employeeGender);
    }
}
