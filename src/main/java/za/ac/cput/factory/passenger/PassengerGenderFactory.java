/* PassengerGenderFactory.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.passenger;

import za.ac.cput.domain.passenger.PassengerGender;
import za.ac.cput.util.Helper;
public class PassengerGenderFactory
{
    public static PassengerGender getPassengerGender(String passengerId,String genId)
    {
        return new PassengerGender.Builder().builderPassengerId(passengerId).builderGenId(genId).build();

    }
}
