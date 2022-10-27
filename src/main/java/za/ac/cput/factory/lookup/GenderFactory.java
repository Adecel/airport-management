package za.ac.cput.factory.lookup;
/*
  Dieuci Djate Nsibu
  220169136
  */

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory {
    public static Gender build(String gender, String description) {
        Helper.checkStringParam("gender", gender);
        Helper.checkStringParam("description", description);

        return Gender.builder().gender(gender).description(description)
                .build();
    }

}
