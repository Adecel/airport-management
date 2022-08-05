package za.ac.cput.factory.department;

//219383448 KISSIMBA NYEMBO ISAAC

import za.ac.cput.domain.department.Luggage;
import za.ac.cput.util.Helper;

public class LuggageFactory {
    public static Luggage createLuggage(String luggageID, String luggageNumber, String luggageType){

        if(Helper.nullOrEmpty(luggageID )|| Helper.nullOrEmpty(luggageNumber) || Helper.nullOrEmpty(luggageType)  )
            return null;
        return new Luggage.Builder().setLuggageID(luggageID)
                .setLuggageNumber(luggageNumber)
                .setLuggageType(luggageType)
                .build();

    }

}
