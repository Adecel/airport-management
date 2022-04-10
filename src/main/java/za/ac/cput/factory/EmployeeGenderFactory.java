/* EmployeeGenderFactory.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.entity.EmployeeGender;

public class EmployeeGenderFactory
{
    public static EmployeeGender createEmployeeGender(String employeeId, String genId)
    {
        EmployeeGender employeeGender =new EmployeeGender.Builder().setemployeeId(employeeId)
                .setgenId(genId).Build();

        return employeeGender;

    }
}
