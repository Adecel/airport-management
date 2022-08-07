/* EmployeeGenderFactory.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.employee;

import za.ac.cput.domain.employee.EmployeeGender;

public class EmployeeGenderFactory
{
     public static EmployeeGender getEmployeeGender(String employeeId, String genId){
         if (employeeId.equals("") || genId.equals("")) return null;
         return new EmployeeGender.Builder().builderEmployeeId(employeeId).builderGenId(genId).build();
     }
}
