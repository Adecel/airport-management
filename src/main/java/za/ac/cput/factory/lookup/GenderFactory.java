/* GenderFactory.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory
{
    public static Gender createGender(String genName)
    {
        String Id= Helper.generateID();
        Gender gender =new Gender.Builder().setgenId(Id)
                .setgenName(genName).Build();

        return gender;

    }
}
