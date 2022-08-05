package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.department.LuggageFactory;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class LuggageFactoryTest {
    @Test
    public void test() {
        Luggage luggage = LuggageFactory.createLuggage("AC243", "08","Foutnitures");
        System.out.println(luggage.toString());
        assertNotNull(luggage);

    }

}