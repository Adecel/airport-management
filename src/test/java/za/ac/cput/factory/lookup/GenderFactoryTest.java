/* GenderFactoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 2022/08/07
*/
package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;

import static org.junit.jupiter.api.Assertions.*;

class GenderFactoryTest {

    @Test
    void getGender() {
        Gender gender= GenderFactory.getGender("");
        Assertions.assertNotNull(gender);
        //System.out.println(gender);
    }
}