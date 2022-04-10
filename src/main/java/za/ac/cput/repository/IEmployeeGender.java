/* IEmployeeGender.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.entity.EmployeeGender;

import java.util.Set;

public interface IEmployeeGender extends  IRepository <EmployeeGender, String>
{
    public Set<EmployeeGender> getAll();
}

