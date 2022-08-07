package za.ac.cput.domain.department;

import org.junit.jupiter.api.Test;
//219383448 KISSIMBA NYEMBO ISAAC

class LuggageTest {
    @Test
    public void test(){
        Luggage luggage = new Luggage.Builder().BuildLuggageID("AC243")
                .BuildLuggageNumber("08")
                .BuildLuggageType("Fournitures")
                .build();
        System.out.println(luggage);
    }

}