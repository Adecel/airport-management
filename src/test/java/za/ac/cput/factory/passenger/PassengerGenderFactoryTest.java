/* PassengerGenderFactoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.passenger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.passenger.PassengerGender;

import static org.junit.jupiter.api.Assertions.*;

class PassengerGenderFactoryTest {

    @Test
    void getPassengerGender() {
        PassengerGender passengerGender= PassengerGenderFactory.getPassengerGender("","");
        Assertions.assertNotNull(passengerGender);
        //System.out.println(passengerGender);
    }
}