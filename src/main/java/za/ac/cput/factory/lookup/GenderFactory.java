/* GenderFactory.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory
{
    public static Gender getGender(String genName)
    {
        return new Gender.Builder().builderGenName(genName).build();
    }
}
