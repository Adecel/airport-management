package za.ac.cput.factory.department;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.department.Luggage;
import za.ac.cput.factory.department.LuggageFactory;

import static org.junit.jupiter.api.Assertions.*;

//219383448 KISSIMBA NYEMBO ISAAC

class LuggageFactoryTest {
    @Test
    void buildWithSuccess(){
        Luggage luggage =  LuggageFactory.build("425156626", "56278", "water");
        System.out.println(luggage);
        assertNotNull(luggage);

    }
    @Test
    void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                LuggageFactory
                        .build("", "56278", "water"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("luggageID"));
    }


}