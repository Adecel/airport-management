package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.Name;
import za.ac.cput.util.Helper;

public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName) {
        Helper.checkStringParam("firstName", firstName);
        Helper.setEmptyIfNull(middleName);
        Helper.checkStringParam("lastName", lastName);

        return Name.builder().firstName(firstName)
                .middleName(middleName).lastName(lastName)
                .build();
    }
}
