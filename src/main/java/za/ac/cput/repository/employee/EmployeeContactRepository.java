package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.EmployeeContact;
@Repository
public interface EmployeeContactRepository extends JpaRepository<EmployeeContact,String > {

    public EmployeeContact findByEmployeeNumber(String employeeNumber);

}
