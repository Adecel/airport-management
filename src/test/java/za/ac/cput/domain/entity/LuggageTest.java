package za.ac.cput.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
//219383448 KISSIMBA NYEMBO ISAAC

class LuggageTest {
    @Test
    public void test(){
        Luggage luggage = new Luggage.Builder().setLuggageID("AC243")
                .setLuggageNumber("08")
                .setLuggageType("Fournitures")
                .build();
        System.out.println(luggage);
    }

}