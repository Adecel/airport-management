/* PassengerGenderRepositoryTest.java
 Author: Hilary Cassidy Nguepi Nangmo (220346887)
 Date: 6 April 2022
*/
package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.passenger.PassengerGenderFactory;
import za.ac.cput.repository.passenger.PassengerGenderRepository;

import static org.junit.jupiter.api.Assertions.*;

class PassengerGenderRepositoryTest {
    private static PassengerGenderRepository repository= PassengerGenderRepository.getRepository();
    private static PassengerGender passengerGender= PassengerGenderFactory.createPassengerGender("GT390876");
    @Test
    void create() {
        PassengerGender created =repository.Create(passengerGender);
        assertEquals(passengerGender.getPassengerId(),created.getPassengerId());
        System.out.println("created"+created);
    }


    @Test
    void read() {
        PassengerGender READ =repository.Read(passengerGender.getPassengerId());
        assertNotNull("read:"+READ);
        System.out.println("read:"+READ);
    }

    @Test
    void update() {
        PassengerGender updated= new PassengerGender.Builder().cody(passengerGender).setgenId("Yui77876")
                .Build();
        assertNotNull(repository.Update(updated));
        System.out.println("update"+updated);
    }

    @Test
    void delete() {
        boolean success=repository.delete(passengerGender.getPassengerId());
        assertTrue(success);
        System.out.println("delete:"+success);
    }

    @Test
    void getAll() {
        System.out.println(" "+repository.getAll());
    }
}
