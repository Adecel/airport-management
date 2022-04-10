/* PassengerGenderRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.entity.PassengerGender;

import java.util.HashSet;
import java.util.Set;

public class PassengerGenderRepository implements IPassengerGender
{
    private  static PassengerGenderRepository repository=null;
    private Set<PassengerGender> PassengerGenderDB=null;

    private  PassengerGenderRepository()
    {
        PassengerGenderDB= new HashSet<PassengerGender>();
    }
    public static PassengerGenderRepository getRepository()
    {
        if(repository==null)
        {
            repository= new PassengerGenderRepository();
        }
        return repository;
    }


    @Override
    public PassengerGender Create(PassengerGender passengerGender) {
        boolean success=PassengerGenderDB.add(passengerGender);
        if(!success)
            return null;
        return passengerGender;
    }

    @Override
    public PassengerGender Read(String passengerId) {
        PassengerGender passengerGender=PassengerGenderDB.stream().
                filter(e ->e.getPassengerId().equals(passengerId))

                .findAny().orElse(null);
        return  passengerGender;
    }

    @Override
    public PassengerGender Update(PassengerGender passengerGender) {
        PassengerGender existingemployeeGender=Read(passengerGender.getPassengerId());
        if (passengerGender !=null)
        {
            System.out.println("removed"+passengerGender);
            PassengerGenderDB.remove(passengerGender);
            PassengerGenderDB.add(passengerGender);
        }
        return passengerGender;
    }

    @Override
    public boolean delete(String passengerId) {
        PassengerGender deleteGender= Read(passengerId);
        if (deleteGender ==null)
        {
            return false;
        }
        PassengerGenderDB.remove(deleteGender);
        return true;
    }
    @Override
    public Set<PassengerGender> getAll() {

        return PassengerGenderDB;
    }
}


