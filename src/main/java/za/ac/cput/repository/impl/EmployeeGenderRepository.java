/* EmployeeGenderRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.EmployeeGender;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepository implements IEmployeeGender
{
    private  static EmployeeGenderRepository repository=null;
    private Set<EmployeeGender> EmployeeDB=null;

    private  EmployeeGenderRepository()
    {
        EmployeeDB= new HashSet<EmployeeGender>();
    }
    public static EmployeeGenderRepository getRepository()
    {
        if(repository==null)
        {
            repository= new EmployeeGenderRepository();
        }
        return repository;
    }

    @Override
    public EmployeeGender Create(EmployeeGender employeeGender) {
        boolean success=EmployeeDB.add(employeeGender);
        if(!success)
            return null;
        return employeeGender;
    }


    @Override
    public EmployeeGender Read(String employeeGenderId) {
        EmployeeGender employeeGender=EmployeeDB.stream().
                filter(e ->e.getEmployeeId().equals(employeeGenderId))

                .findAny().orElse(null);
        return  employeeGender;
    }

    @Override
    public EmployeeGender Update(EmployeeGender employeeGender) {

        EmployeeGender existingemployeeGender=Read(employeeGender.getEmployeeId());
        if (employeeGender !=null)
        {
            System.out.println("removed"+employeeGender);
            EmployeeDB.remove(employeeGender);
            EmployeeDB.add(employeeGender);
        }
        return employeeGender;
    }

    @Override
    public boolean delete(String employeeid) {
        EmployeeGender deleteEmployeeGender= Read(employeeid);
        if (deleteEmployeeGender ==null)
        {
            return false;
        }
        EmployeeDB.remove(deleteEmployeeGender);
        return true;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return EmployeeDB;
    }
}


