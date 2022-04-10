/* PassengerGenderFactory.java
  Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.domain.entity.PassengerGender;
import za.ac.cput.util.Helper;
public class PassengerGenderFactory
{
    public static PassengerGender createPassengerGender(String genId)
    {
        String Id= Helper.generateID();
        PassengerGender passengergender =new PassengerGender.Builder().setpassengerId(Id)
                .setgenId(genId).Build();

        return passengergender;

    }
}
