/* GenderRepository.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.lookup;

import za.ac.cput.domain.lookup.Gender;

import java.util.HashSet;
import java.util.Set;

public class GenderRepository  implements IGender
{
    private  static GenderRepository  repository=null;
    private Set<Gender> GenderDB=null;

    private  GenderRepository()
    {
        GenderDB= new HashSet<Gender>();
    }
    public static GenderRepository getRepository()
    {
        if(repository==null)
        {
            repository= new GenderRepository();
        }
        return repository;
    }

    @Override
    public Gender Create(Gender gender)
    {
        boolean success=GenderDB.add(gender);
        if(!success)
            return null;
        return gender;

    }

    @Override
    public Gender Read(String genId)
    {
        Gender gender=GenderDB.stream().
                filter(e ->e.getGenId().equals(genId))

                .findAny().orElse(null);
        return  gender;
    }

    @Override
    public Gender Update(Gender gender) {

        Gender existingGender=Read(gender.getGenId());
        if (existingGender !=null)
        {
            System.out.println("removed"+existingGender);
            GenderDB.remove(existingGender);
            GenderDB.add(gender);
        }
        return gender;
    }

    @Override
    public boolean delete(String genId) {
        Gender deleteGender= Read(genId);
        if (deleteGender ==null)
        {
            return false;
        }
        GenderDB.remove(deleteGender);
        return true;
    }

    @Override
    public Set<Gender> getAll() {
        return GenderDB;
    }
}


