/* EmployeeGenderFactoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/

package za.ac.cput.factory.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.EmployeeGender;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeGenderFactoryTest {

    @Test
    void getEmployeeGender() {
        EmployeeGender employeeGender= EmployeeGenderFactory.getEmployeeGender("","");
        Assertions.assertNotNull(employeeGender);
    }
}