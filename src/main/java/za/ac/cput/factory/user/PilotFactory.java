package za.ac.cput.factory.user;

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Pilot;
import za.ac.cput.domain.user.User;
import za.ac.cput.factory.lookup.GenderFactory;
import za.ac.cput.factory.lookup.NameFactory;
import za.ac.cput.util.Helper;

public class PilotFactory {

    public static Pilot build(int id, Name name, Gender gender, String phoneNumber) {
        name = NameFactory.build(name.getFirstName(), name.getMiddleName(), name.getLastName());
        gender = GenderFactory.build(gender.getGender(), gender.getDescription());
        Helper.checkStringParam("phoneNumber", phoneNumber);
        return Pilot.builder().id(id).name(name).gender(gender).phoneNumber(phoneNumber)
                .build();
    }
}
