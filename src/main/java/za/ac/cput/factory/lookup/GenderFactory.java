/* GenderFactory.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.util.Helper;

import java.util.IllegalFormatCodePointException;
import java.util.UUID;

public class GenderFactory
{
    public static Gender getGender(String genName)
    {
        if (genName.equals("")) return null;
        return new Gender.Builder().builderGenId(UUID.randomUUID().toString()).builderGenName(genName).build();
    }
}
