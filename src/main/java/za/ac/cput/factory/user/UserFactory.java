package za.ac.cput.factory.user;
/*
  Adecel Rusty Mabiala
  219197229
 */

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.lookup.GenderFactory;
import za.ac.cput.factory.lookup.NameFactory;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User build(int id, Name name, Gender gender) {
        name = NameFactory.build(name.getFirstName(), name.getMiddleName(), name.getLastName());
        gender = GenderFactory.build(gender.getGender(), gender.getDescription());
        return User.builder().id(id).name(name).gender(gender)
                .build();
    }

}
