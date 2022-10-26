package za.ac.cput.factory.user;
/*
  Mogamad Tawfeeq Cupido
  216266882
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.Gender;
import za.ac.cput.domain.lookup.Name;
import za.ac.cput.domain.user.Pilot;
import za.ac.cput.domain.user.User;

import static org.junit.jupiter.api.Assertions.*;

class PilotFactoryTest {

    @Test
    void buildWithSuccess() {
        Pilot pilot_a = PilotFactory.build(11,
                new Name("Adecel", "Rusty", "Mabiala"),
                new Gender("M","Male"), "123456789");
        int pilotId = pilot_a.getId();
        assertNotEquals("11", pilotId);
        System.out.println(pilot_a);
    }

    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class,() ->
                PilotFactory.build(0,
                        new Name("Adecel", "Rusty", ""),
                        new Gender("M","Male"), "123456789"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("id"));
    }
}