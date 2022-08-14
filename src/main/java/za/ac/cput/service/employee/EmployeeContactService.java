package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.EmployeeContact;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeContactService extends IService<EmployeeContact,String> {

    List<EmployeeContact> findAll();

}
