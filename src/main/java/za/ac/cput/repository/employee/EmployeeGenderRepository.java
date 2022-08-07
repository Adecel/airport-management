/* EmployeeGenderRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.employee;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.employee.EmployeeGender;
import za.ac.cput.domain.lookup.Gender;

import java.util.HashSet;
import java.util.Set;

public interface EmployeeGenderRepository extends JpaRepository<EmployeeGender,String>
{

}


